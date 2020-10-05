package com.bank.kata.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Transaction {
    private String date;
    private int amount;
}
