/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class Bank  {

     Map<String,Customer> customerMap;
	Bank()
	{
		customerMap = new HashMap <String,Customer>();
	}
	public static void main(String []args)
	{
		Scanner sc  =  new Scanner(System.in);
		Customer customer;
		String username,password;double amount;
		Bank bank  =  new Bank();
		int choice;
	outer:	while(true)
		{
			System.out.println("\n-------------------");
			System.out.println("BANK    OF     JAVA");
			System.out.println("-------------------\n");
			System.out.println("1. Register account.");
			System.out.println("2. Login.");
			System.out.println("3. Update accounts.");
			System.out.println("4. Exit.");
			System.out.print("\nEnter your choice : ");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
				case 1:
					System.out.print("Enter name : ");
					String name = sc.nextLine();
					System.out.print("Enter address : ");
					String address = sc.nextLine();
					System.out.print("Enter contact number : ");
					String phone = sc.nextLine();
					System.out.println("Set username : ");
					username = sc.next();
					while(bank.customerMap.containsKey(username))
					{
						System.out.println("Username already exists. Set again : ");
						username = sc.next();
					}
					System.out.println("Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) :");
					password = sc.next();
					sc.nextLine();
					while(!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}"))))
					{
						System.out.println("Invalid password condition. Set again :");
						password=sc.next();
					}
					System.out.print("Enter initial deposit : ");
					sc.hasNextDouble();
					while(!sc.hasNextDouble())
					{
						System.out.println("Invalid amount. Enter again :");
						sc.nextLine();
					}
					amount=sc.nextDouble();
					sc.nextLine();
                                        System.out.println("Your Account is Saving Acount ::::\n "
                                                + "So How much will you save per month : ");
                                        
                                       double SavingAmount =sc.nextDouble();
                                        
                                        SavingsAccount sa = new SavingsAccount(SavingAmount);
					customer = new Customer(username,password,name,address,phone,amount,new Date(),sa.getSavingsBalance(),sa.calculateMonthlyInterest());
					bank.customerMap.put(username,customer);
					break;
				case 2:
					System.out.println("Enter username : ");
					username = sc.next();
					sc.nextLine();
					System.out.println("Enter password : ");
					password = sc.next();
					sc.nextLine();
					if(bank.customerMap.containsKey(username))
					{
						customer = bank.customerMap.get(username);
						if(customer.password.equals(password))
						{
							while(true)
							{
								System.out.println("\n-------------------");
								System.out.println("W  E  L  C  O  M  E");
								System.out.println("-------------------\n");
								System.out.println("1. Deposit.");
								System.out.println("2. Withrdraw.");
                                                                System.out.println("3. Transfer.");
                                                                System.out.println("4. Open Investment wallet");
                                                                System.out.println("5. Loan From Bank");
								System.out.println("6. Last 5 transactions.");
								System.out.println("7. User information.");
								System.out.println("8. Log out.");
								System.out.print("\nEnter your choice : ");
								choice = sc.nextInt();
								sc.nextLine();
								switch(choice)
								{
									case 1:
									       System.out.print("Enter amount : ");
									       while(!sc.hasNextDouble())
									       {
										       System.out.println("Invalid amount. Enter again :");
										       sc.nextLine();
									       }
									       amount = sc.nextDouble();
									       sc.nextLine();
	                                                                       customer.deposit(amount,new Date());
									       break;
									case 2:
									       System.out.print("Enter payee username : ");
									       username = sc.next();
									       sc.nextLine();
									       System.out.println("Enter amount : ");
									       while(!sc.hasNextDouble())
									       {
										       System.out.println("Invalid amount. Enter again :");
										       sc.nextLine();
									       }
									       amount = sc.nextDouble();
									       sc.nextLine();
									       if(amount > customer.balance)
									       {
										       System.out.println("Your Balance Can not withdraw . Contact bank manager.");
										       break;
									       }
									       if(bank.customerMap.containsKey(username))
									       {
										       Customer payee = bank.customerMap.get(username);
										       payee.withdraw(amount,new Date());
										       customer.withdraw(amount,new Date());
									       }
									       else
									       {
										       System.out.println("Username doesn't exist.");
									       }
									       break;
                                                                        case 3:
                                                                        {
                                                                       
									       System.out.print("Enter amount : ");
									       while(!sc.hasNextDouble())
									       {
										       System.out.println("Invalid amount. Enter again :");
										       sc.nextLine();
									       }
									       double amountTr = sc.nextDouble();
									       sc.nextLine();
                                                                               System.out.println ("Enter Transfer information : ");
                                                                               System.out.print("The recipient's name :");
                                                                               String Name = sc.next();
                                                                               System.out.print("The recipient's phone : ");
                                                                               String phoneN = sc.next();
                                                                               System.out.print("The recipient's Place  : ");
                                                                               String place = sc.next();
                                                                               customer.TransferMoney(
                                                                                       amountTr ,Name, phoneN, place, new Date());
                                                                               
                                                                               System.out.println("........sent succesfully ......");
                                                                        }
                                                                            break;   
                                                                        case 4:
                                                                            System.out.print("Enter amount : ");
                                                                             while(!sc.hasNextDouble())
									       {
										       System.out.println("Invalid amount. Enter again :");
										       sc.nextLine();
									       }
									     double  amountIn = sc.nextDouble();
                                                                             Investment in = new Investment(amountIn);  
                                                                             System.out.println("Bank will make sure your balance is sufficient........");
                                                                             if(in.Cheak(customer.balance)==true)
                                                                             {
                                                                                 System.out.println("You can open an investment portfolio, please see the bank");
                                                                             }
                                                                             else
                                                                             {
                                                                                  System.out.println("You can  not open an investment portfolio, because the "
                                                                                          + "amount is bigger than your balance ");
  
                                                                             }
                                                                            
                                                                            break ;
                                                                        case 5:
                                                                            System.out.print("Enter amount : ");
                                                                             while(!sc.hasNextDouble())
									       {
										       System.out.println("Invalid amount. Enter again :");
										       sc.nextLine();
									       }
									     double  amountLoan = sc.nextDouble();
                                                                             Loan L= new Loan(amountLoan,new Date());
                                                                             L.print();
                                                                             System.out.print("Please check with the bank to confirm the borrowing process");
                                                                            break;
									case 6:
									       for(String transactions : customer.transactions)
									       {
										       System.out.println(transactions);
									       }
									       break;
									case 7:
									       System.out.println("Accountholder name : "+customer.name);
									       System.out.println("Accountholder address : "+customer.address);
									       System.out.println("Accountholder contact : "+customer.phone);
									       break;
									case 8:
									       continue outer;
								        default:
									        System.out.println("Wrong choice !");
								}
							}
						}
						else
						{
							System.out.println("Wrong username/password.");
						}
					}
					else
					{
						System.out.println("Wrong username/password.");
					}
					break;
				case 3:
					System.out.println("Enter username : ");
					username = sc.next();
					if(bank.customerMap.containsKey(username))
					{
						bank.customerMap.get(username).update(new Date());
					}
					else
					{
						System.out.println("Username doesn't exist.");
					}
					break;
				case 4:
					System.out.println("\nThank you for choosing Bank Of Java."); 
					System.exit(1);
					break;
				default:
					System.out.println("Wrong choice !");
			}
		}
	}
}