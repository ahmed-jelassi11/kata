package com.bank.kata.repository;

import com.bank.kata.model.Account;
import com.bank.kata.service.Clock;
import com.bank.kata.model.Transaction;

import java.util.List;

public class TransactionRepository {


    private Account account;
    private Clock clock;

    public TransactionRepository(Account account, Clock clock) {
        this.account = account;
        this.clock = clock;
    }

    public void addDeposit(int amount) {
        account.addTransaction(Transaction.builder().date(clock.now()).amount(amount).build());
    }

    public void addWithdrawal(int amount) {
        account.addTransaction(Transaction.builder().date(clock.now()).amount(-amount).build());
    }

    public List<Transaction> allTransactions() {
        return account.getTransactions();
    }
}
