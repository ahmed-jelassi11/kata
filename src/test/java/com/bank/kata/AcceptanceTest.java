package com.bank.kata;

import com.bank.kata.model.Account;
import com.bank.kata.repository.TransactionRepository;
import com.bank.kata.service.AccountService;
import com.bank.kata.service.StatementPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class AcceptanceTest {

    private AccountService accountService;
    private Account account;

    @BeforeEach
    public void init() {
        account = new Account(UUID.randomUUID().toString());
        TransactionRepository transactionRepository = new TransactionRepository(account);
        StatementPrinter statementPrinter = new StatementPrinter();
        accountService = new AccountService(transactionRepository, statementPrinter);
    }

    @Test
    public void printStatementTest() {

        accountService.deposit(1000);
        accountService.withdraw(100);
        accountService.deposit(500);

        accountService.printStatement();
    }
}
