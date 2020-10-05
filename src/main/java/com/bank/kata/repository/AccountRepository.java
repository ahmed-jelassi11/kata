package com.bank.kata.repository;

import com.bank.kata.repository.TransactionRepository;
import com.bank.kata.service.StatementPrinter;

public class AccountRepository {


    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;

    public AccountRepository(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        transactionRepository.addWithdrawal(amount);
    }

    public void printStatement() {
        statementPrinter.print(transactionRepository.allTransactions());
    }


}
