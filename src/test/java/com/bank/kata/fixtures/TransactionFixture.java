package com.bank.kata.fixtures;

import com.bank.kata.model.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionFixture {

    private final static String TODAY = "05/10/2020";

    public static Transaction getDepositTransaction() {
        return Transaction.builder().date(TODAY).amount(500).build();
    }

    public static Transaction getWithDrawTransaction() {
        return Transaction.builder().date(TODAY).amount(-500).build();
    }

    public static List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(Transaction.builder().date("20/09/2020").amount(500).build());
        transactions.add(Transaction.builder().date("22/09/2020").amount(-200).build());
        transactions.add(Transaction.builder().date("05/10/2020").amount(1000).build());
        return transactions;
    }
}
