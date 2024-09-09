/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

/**
 *
 * @author dell
 */
public class Investment {
    double amount ; 

    public Investment(double amount) {
        this.amount = amount;
    }

   public boolean Cheak(double balance)
   {
       if(amount >balance)
           return false ;
       else 
           return true ; 
       
             
   }
    
}
