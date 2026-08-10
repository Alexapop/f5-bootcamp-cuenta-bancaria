package com.factoriaf5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentAccountTest {
    

    @Test
    void WithdrawShouldCreateOverdraftWhenItExceedsBalance(){
        CurrentAccount account = new CurrentAccount(200f, 0f);
       account.withdraw(300f);
       assertEquals(0f, account.balance);
       assertEquals(100f, account.overdraft);
    }

    @Test
    void shouldClearOverdraftAndKeepBalanceWhenDepositExceedsOverdraft(){
        CurrentAccount account = new CurrentAccount(0f, 0f);
        account.withdraw(100f);
        account.deposit(200f);
        assertEquals(0f, account.overdraft);
        assertEquals(100f, account.balance);
        assertEquals(1, account.numberOfDeposits);

    }

    @Test
    void shouldReduceBalanceWhenWithdrawalDoesNotExceedBalance(){
        CurrentAccount account = new CurrentAccount(500f, 0f);
        account.withdraw(200f);
        assertEquals(300f, account.balance);
        assertEquals(0f, account.overdraft);
        assertEquals(1, account.numberOfWithdrawals);
    }

    @Test
    void shouldReduceOverdraftWhenDepositIsLowerThanOverdraft(){
        CurrentAccount account = new CurrentAccount(0f, 0f);
        account.withdraw(300f);
        account.deposit(100f);
        assertEquals(0f, account.balance);
        assertEquals(200f, account.overdraft);
        assertEquals(1, account.numberOfDeposits);
    }
}
