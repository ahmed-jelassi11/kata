package com.bank.kata.service;

import com.bank.kata.repository.TransactionRepository;

public class AccountService {


    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;

    public AccountService(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
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
