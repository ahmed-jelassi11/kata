package com.bank.kata.repository;

import com.bank.kata.fixtures.AccountFixture;
import com.bank.kata.fixtures.TransactionFixture;
import com.bank.kata.model.Account;
import com.bank.kata.service.ClockService;
import com.bank.kata.model.Transaction;
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
    ClockService clockService;

    @BeforeEach
    public void init() {
        Account account = AccountFixture.getAccount();
        transactionRepository = new TransactionRepository(account, clockService);
    }

    @Test
    public void test_create_deposit_transaction() {
        given(clockService.now()).willReturn(TODAY);
        transactionRepository.addDeposit(500);
        List<Transaction> transactions = transactionRepository.allTransactions();
        assertEquals(1, transactions.size());
        assertEquals(TransactionFixture.getDepositTransaction(), transactions.get(0));
    }

    @Test
    public void test_create_withdraw_transaction() {
        given(clockService.now()).willReturn(TODAY);
        transactionRepository.addWithdrawal(500);
        List<Transaction> transactions = transactionRepository.allTransactions();
        assertEquals(1, transactions.size());
        assertEquals(TransactionFixture.getWithDrawTransaction(), transactions.get(0));
    }

}
