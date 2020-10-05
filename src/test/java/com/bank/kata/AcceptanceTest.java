package com.bank.kata;

import com.bank.kata.fixtures.AccountFixture;
import com.bank.kata.model.Account;
import com.bank.kata.model.Console;
import com.bank.kata.repository.AccountRepository;
import com.bank.kata.repository.TransactionRepository;
import com.bank.kata.service.ClockService;
import com.bank.kata.service.StatementPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.bank.kata.service.StatementPrinter.STATEMENT_HEADER;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
public class AcceptanceTest {

    @Mock
    ClockService clockService;
    @Mock
    Console console;

    private AccountRepository accountRepository;
    private Account account;

    @BeforeEach
    public void init() {
        account = AccountFixture.getAccount();
        TransactionRepository transactionRepository = new TransactionRepository(account, clockService);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        accountRepository = new AccountRepository(transactionRepository, statementPrinter);
    }

    @Test
    public void test_print_all_transaction_statement() {
        given(clockService.now()).willReturn("20/09/2020", "22/09/2020", "05/10/2020");
        accountRepository.deposit(500);
        accountRepository.withdraw(200);
        accountRepository.deposit(1000);

        accountRepository.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine(STATEMENT_HEADER);
        inOrder.verify(console).printLine("05/10/2020 | 1000 | 1300");
        inOrder.verify(console).printLine("22/09/2020 | -200 | 300");
        inOrder.verify(console).printLine("20/09/2020 | 500 | 500");
    }
}
