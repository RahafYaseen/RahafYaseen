/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.util.Date;

/**
 *final double rate = 0.04,limit = 10000,limit1 = 200;
 * @author dell
 */
class SavingsAccount {
    

    private static double annualInterestRate = 0.10f;
    private double savingsBalance = 0.0f;

    public SavingsAccount(double savingsBalance){
        setSavingsBalance(savingsBalance);
    }
    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }
   
    public double getSavingsBalance(){
        return this.savingsBalance;
    }
    public static double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public double calculateMonthlyInterest(){
       double MonthlyInterest = savingsBalance + (savingsBalance * annualInterestRate) / 12;
        return savingsBalance ;
    }
    public String toString(){
        return String.format("%.2f", getSavingsBalance());
    }

}

