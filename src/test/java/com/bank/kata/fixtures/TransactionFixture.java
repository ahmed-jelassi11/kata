package com.bank.kata.fixtures;

import com.bank.kata.model.Transaction;

public class TransactionFixture {

    private final static String TODAY = "05/10/2020";

    public static Transaction getDepositTransaction() {
        return Transaction.builder().date(TODAY).amount(500).build();
    }
    public static Transaction getWithDrawTransaction() {
        return Transaction.builder().date(TODAY).amount(-500).build();
    }
}
