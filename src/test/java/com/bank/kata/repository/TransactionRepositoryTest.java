package com.bank.kata.repository;

import com.bank.kata.fixtures.AccountFixture;
import com.bank.kata.fixtures.TransactionFixture;
import com.bank.kata.model.Account;
import com.bank.kata.model.Clock;
import com.bank.kata.model.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TransactionRepositoryTest {

    public static final String TODAY = "05/10/2020";
    private TransactionRepository transactionRepository;
    @Mock
    Clock clock;

    @BeforeEach
    public void init() {
        Account account = AccountFixture.getAccount();
        transactionRepository = new TransactionRepository(account, clock);
    }

    @Test
    public void test_create_deposit_transaction() {
        given(clock.todayAsString()).willReturn(TODAY);
        transactionRepository.addDeposit(500);
        List<Transaction> transactions = transactionRepository.allTransactions();
        assertEquals(1, transactions.size());
        assertEquals(TransactionFixture.getDepositTransaction().getAmount(), transactions.get(0).getAmount());
        assertEquals(TransactionFixture.getDepositTransaction().getDate(), transactions.get(0).getDate());
    }

    @Test
    public void test_create_withdraw_transaction() {
        given(clock.todayAsString()).willReturn(TODAY);
        transactionRepository.addWithdrawal(500);
        List<Transaction> transactions = transactionRepository.allTransactions();
        assertEquals(1, transactions.size());
        assertEquals(TransactionFixture.getWithDrawTransaction().getAmount(), transactions.get(0).getAmount());
        assertEquals(TransactionFixture.getWithDrawTransaction().getDate(), transactions.get(0).getDate());
    }

}
