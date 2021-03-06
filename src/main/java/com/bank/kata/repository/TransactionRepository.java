package com.bank.kata.repository;

import com.bank.kata.model.Account;
import com.bank.kata.service.ClockService;
import com.bank.kata.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class TransactionRepository {


    private Account account;
    private ClockService clockService;

    public TransactionRepository(Account account, ClockService clockService) {
        this.account = account;
        this.clockService = clockService;
    }

    public void addDeposit(BigDecimal amount) {
        account.addTransaction(Transaction.builder().date(clockService.now()).amount(amount).build());
    }

    public void addWithdrawal(BigDecimal amount) {
        account.addTransaction(Transaction.builder().date(clockService.now()).amount(amount.negate()).build());
    }

    public List<Transaction> allTransactions() {
        return account.getTransactions();
    }
}
