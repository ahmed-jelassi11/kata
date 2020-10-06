package com.bank.kata.repository;

import com.bank.kata.fixtures.TransactionFixture;
import com.bank.kata.model.Transaction;
import com.bank.kata.service.StatementPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountRepositoryTest {

    @Mock
    TransactionRepository transactionRepository;
    @Mock
    StatementPrinter statementPrinter;

    private AccountRepository accountRepository;

    @BeforeEach
    public void init() {
        accountRepository = new AccountRepository(transactionRepository, statementPrinter);
    }

    @Test
    public void test_deposit_transaction() {
        accountRepository.deposit(BigDecimal.valueOf(100));
        verify(transactionRepository).addDeposit(BigDecimal.valueOf(100));
    }

    @Test
    public void test_withdraw_transaction() {
        accountRepository.withdraw(BigDecimal.valueOf(100));
        verify(transactionRepository).addWithdrawal(BigDecimal.valueOf(100));
    }

    @Test
    public void test_print_statement() {
        List<Transaction> transactions = asList(TransactionFixture.getDepositTransaction());
        given(transactionRepository.allTransactions()).willReturn(transactions);
        accountRepository.printStatement();
        verify(statementPrinter).print(transactions);
    }
}
