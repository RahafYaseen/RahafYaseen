/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.util.Date;

/**
 *
 * @author rahaf
 */
public class Loan {
    double amount;
    Date Date ;
    double monthly_payments ;
    public Loan(double amount, Date date) {
        this.amount = amount;
        this.Date = Date;
        monthly_payments =0 ;
    }
    
    public void print()
    {
       this.monthly_payments =amount/12 ;
       
       System.out.println("Your Loan amount is : " +amount 
       + "       You have to pay :" + monthly_payments + "   mounthly for year ");
    }

}
