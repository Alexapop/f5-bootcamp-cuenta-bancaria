package com.factoriaf5.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    void depositShouldIncreaseBalanceAndDepositCount() {
        Account account = new Account(2000f, 2f);
        account.deposit(100f);
        assertEquals(2100f, account.balance);
        assertEquals(1, account.numberOfDeposits);
    }

    @Test
    void withdrawShouldDecreaseBalanceAndIncreaseWithdrawalCount() {
        Account account = new Account(1500f, 2f);

        account.withdraw(450f);
        assertEquals(1050f, account.balance);
        assertEquals(1, account.numberOfWithdrawals);
    }

    @Test
    void shouldCalculateMonthlyInterest() {
        Account account = new Account(4000f, 2f);

        account.calculateMonthlyInterest();

        assertEquals(4006.6667f, account.balance);
    }


    @Test
    void withdrawShouldNotAllowOverdraft() {
        Account account = new Account(1500f, 2f);

        account.withdraw(2000f);

        assertEquals(1500f, account.balance);
        assertEquals(0, account.numberOfWithdrawals);
    }

    @Test
    void shouldCalculateMonthlyStatement() {
        Account account = new Account(1000f, 12f);
        account.monthlyFee = 100f;

        account.calculateMonthlyStatement();

        assertEquals(909f, account.balance);
    }

 }
