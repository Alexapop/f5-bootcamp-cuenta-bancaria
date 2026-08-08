package com.factoriaf5;

public class Account {

    protected float balance;
    protected int numberOfDeposits;
    protected int numberOfWithdrawals;
    protected float annualInterestRate;
    protected float monthlyFee;

    public Account(float balance, float annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    protected void deposit(float amount) {
        if (amount > 0) {
            this.balance = this.balance + amount;
            this.numberOfDeposits = this.numberOfDeposits + 1;
        }
    }

    protected void withdraw(float amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance = this.balance - amount;
            this.numberOfWithdrawals = this.numberOfWithdrawals + 1;
        }

    }

    protected void calculateMonthlyInterest() {
        float monthlyRate = this.annualInterestRate / 12 / 100;
        float monthlyInterest = this.balance * monthlyRate;
        this.balance = this.balance + monthlyInterest;

    }

    protected void calculateMonthlyStatement() {
        this.balance = this.balance - this.monthlyFee;
        this.calculateMonthlyInterest();

    }

    protected void print() {
        System.out.println("Balance:" + this.balance);
        System.out.println("Number of deposits:" + this.numberOfDeposits);
        System.out.println("Number of withdrawals:" + this.numberOfWithdrawals);
        System.out.println("Annual interest rate:" + this.annualInterestRate);
        System.out.println("Monthly fee:" + this.monthlyFee);

    }
}
