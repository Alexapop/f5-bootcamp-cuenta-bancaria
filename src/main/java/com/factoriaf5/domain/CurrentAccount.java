package com.factoriaf5.domain;

public class CurrentAccount extends Account {

    protected float overdraft = 0f;

    public CurrentAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
    }

    @Override
    protected void withdraw(float amount) {

        if (amount <= balance) {
            super.withdraw(amount);
        } else {
            this.overdraft = this.overdraft + (amount - this.balance);
            this.balance = 0;
            this.numberOfWithdrawals++;
        }

    }

    @Override
    protected void deposit(float amount) {
        super.deposit(amount);
        if (overdraft <= amount) {
        this.balance = this.balance - this.overdraft;
        this.overdraft = 0;

        } else {
            this.overdraft = this.overdraft -amount;
            this.balance = 0;
        }
    }
    

    @Override
    protected void calculateMonthlyStatement(){
        super.calculateMonthlyStatement();
    }
 
     @Override
     protected void print (){
        System.out.println("Balance:" + this.balance);
        System.out.println("Monthly interest:" + this.monthlyFee);
        System.out.println("Total number of transanctions:" + (this.numberOfWithdrawals + this.numberOfDeposits));
        System.out.println("Overdraft:" + this.overdraft);
    }

}
