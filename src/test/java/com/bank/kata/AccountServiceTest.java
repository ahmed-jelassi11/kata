package com.bank.kata;

import com.bank.kata.model.Transaction;
import com.bank.kata.repository.TransactionRepository;
import com.bank.kata.service.AccountService;
import com.bank.kata.service.StatementPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    TransactionRepository transactionRepository;
    @Mock
    StatementPrinter statementPrinter;

    private AccountService accountService;

    @BeforeEach
    public void init() {
        accountService = new AccountService(transactionRepository, statementPrinter);
    }

    @Test
    public void test_deposit_transaction() {
        accountService.deposit(100);
        verify(transactionRepository).addDeposit(100);
    }

    @Test
    public void test_withdraw_transaction() {
        accountService.withdraw(100);
        verify(transactionRepository).addWithdrawal(100);
    }

    @Test
    public void test_print_statement() {
        List<Transaction> transactions = asList(Transaction.builder().build());
        given(transactionRepository.allTransactions()).willReturn(transactions);

        accountService.printStatement();
        verify(statementPrinter).print(transactions);
    }
}
