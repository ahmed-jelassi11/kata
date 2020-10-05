package com.bank.kata;

import com.bank.kata.fixtures.AccountFixture;
import com.bank.kata.model.Account;
import com.bank.kata.model.Clock;
import com.bank.kata.repository.AccountRepository;
import com.bank.kata.repository.TransactionRepository;
import com.bank.kata.service.StatementPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

public class AcceptanceTest {

    private AccountRepository accountRepository;
    private Account account;
    @Mock
    Clock clock;

    @BeforeEach
    public void init() {
        account = AccountFixture.getAccount();
        TransactionRepository transactionRepository = new TransactionRepository(account, clock);
        StatementPrinter statementPrinter = new StatementPrinter();
        accountRepository = new AccountRepository(transactionRepository, statementPrinter);
    }

    @Test
    public void printStatementTest() {
        accountRepository.deposit(1000);
        accountRepository.withdraw(100);
        accountRepository.deposit(500);

        accountRepository.printStatement();
    }
}
