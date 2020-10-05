package com.bank.kata.repository;

import com.bank.kata.model.Account;
import com.bank.kata.model.Transaction;

import java.util.List;

public class TransactionRepository {


    private Account account;

    public TransactionRepository(Account account) {
        this.account = account;
    }

    public void addDeposit(int amount) {
        throw new UnsupportedOperationException();
    }

    public void addWithdrawal(int amount) {
        throw new UnsupportedOperationException();
    }

    public List<Transaction> allTransactions() {
        throw new UnsupportedOperationException();
    }
}
