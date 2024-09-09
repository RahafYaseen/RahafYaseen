/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author rahaf
 */

 class Customer extends Transfer  
{
	String username,password,name,address,phone;
	double balance;
        final double rate = 0.04,limit = 10000,limit1 = 200;
	ArrayList<String> transactions;
        double savingsBalance ;
        double MonthlyInterest ;
	Customer(String username,String password,String name,String address,String phone,double balance,Date date,double savingsBalance,double MonthlyInterest)
	{

            
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.balance = balance;
                this.savingsBalance=savingsBalance ;
		transactions  =  new ArrayList<String>(5);
		addTransaction(String.format("Initial deposit - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
	}
  
	void update(Date date)
	{
		if(balance>= 10000)
		{
			balance += rate*balance;
		}
		else
		{
			balance -= (int)(balance/100.0);
		}
		addTransaction(String.format("Account updated. Balance - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
	}
	public void deposit(double amount,Date date)
	{
		balance += amount;
		addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" credited to your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
	}
	public void withdraw(double amount,Date date)
	{
		if(amount>(balance))
		{
			System.out.println("Insufficient balance.");
			return;
		}
		balance -= amount;
		addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" debited from your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
	}
	private void addTransaction(String message)
	{
			transactions.add(0,message);
			if(transactions.size()>5)
			{
				transactions.remove(5);
				transactions.trimToSize();
			}
	}

	
    
   

    @Override
    public void TransferMoney(double amount, String Name, String phoneN, String placem, Date d) {
        if(amount>(balance))
		{
			System.out.println("Insufficient balance.");
			return;
		}
		balance -= amount;
		addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+
                        " debited from your account. Balance  - " +NumberFormat.getCurrencyInstance().format(balance)+
                        " Due to a transfer in the name of : "
                        +Name+" as on " + "%1$tD"
                                +" at "+"%1$tT.",d
                ));
    }

    
}

