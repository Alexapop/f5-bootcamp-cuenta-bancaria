package com.factoriaf5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavingAccountTest {
    
    @Test
    void accountShouldBeActiveWhenBalanceIsMoreThanTenThousands(){

        SavingsAccount account = new SavingsAccount(10000f, 5f);
       assertTrue(account.isActive);
    }

    @Test
    void accountShouldBeInactiveWhenBalanceIsLessThanTenThousands(){
        SavingsAccount account = new SavingsAccount(9000f,5f);
        assertFalse(account.isActive);
    }
    @Test
    void accountShouldUpdateBalanceWhenWithdrawal(){
     SavingsAccount account = new SavingsAccount(20000f,5f);
      account.withdraw(1500f);
      assertEquals(18500f, account.balance);
    }

    @Test
    void accountShouldApplyFeeWhenMoreThanFourWithdrawal(){
        SavingsAccount account = new SavingsAccount(15000f,0f);
        account.withdraw(600f);
        account.withdraw(400f);
        account.withdraw(1000f);
        account.withdraw(300f);
        account.withdraw(700f);

        account.calculateMonthlyStatement();

    
        assertEquals(1000f, account.monthlyFee);
        assertEquals(11000f,account.balance);
}

}
