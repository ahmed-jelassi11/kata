package com.bank.kata.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String id;
    private List<Transaction> transactions;
    private BigDecimal balance;

    public Account(String id) {
        this.id = id;
        this.transactions = new ArrayList<>();
        this.balance = BigDecimal.ZERO;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
}
