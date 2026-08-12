package com.factoriaf5.domain;

public class SavingsAccount extends Account {

    protected boolean isActive;

      public SavingsAccount (float balance, float annualInterestRate) {
       super(balance, annualInterestRate);

       this.updateStatus();
      }

    protected void updateStatus() {
        if (this.balance >= 10000) {
            this.isActive = true;
        } else {
            this.isActive = false;

        }
    }
     @Override
    protected void deposit(float amount) {
        if (this.isActive){
        super.deposit(amount);
        this.updateStatus();
        }
    }
      
    @Override
    protected void withdraw(float amount) {
        if (this.isActive){
        super.withdraw(amount);
        this.updateStatus();
        }
    }
 

    @Override
    protected void calculateMonthlyStatement(){      
      if (this.numberOfWithdrawals > 4){
        int extraWithdrawals = this.numberOfWithdrawals - 4;
        this.monthlyFee =this.monthlyFee + (extraWithdrawals * 1000);
      } 
        super.calculateMonthlyStatement();
        this.updateStatus();
      }
      
      @Override
      protected void print (){
     System.out.println("Savings account balance:" + this.balance);
     System.out.println("Savings account monthly fee:" + this.monthlyFee);
     System.out.println("Savings account total transactions:" + (this.numberOfDeposits + this.numberOfWithdrawals));
      }

     }

    

  


