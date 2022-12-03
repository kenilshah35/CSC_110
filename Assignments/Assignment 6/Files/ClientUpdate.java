/*
* Name: Kenil C. Shah
* ID: V00903842
* Date: 21 March 2018
* Filename: ClientUpdate.java
* Details: CSc 110 Assignment 6
*/

import java.util.*;
import java.io.*;

/*
 * The class ClientUpdate contains methods
 * main,setInfo,displayInfo,accountTransactions
 * which are called to open and edit accounts
 * based on a file input given by the user
*/
public class ClientUpdate{
	
	/*
	 * The main method calls method setInfo,displayInfo and accountTransactions
	 * to create and update clients bank informations
	*/
	public static void main (String[] args) throws FileNotFoundException{
		
		//Initialising a new scanner object
		Scanner sc = new Scanner(System.in);
		
		System.out.println("T R A N S A C T I O N   U P D A T I N G\n\n\n");
		System.out.println("Input: ");
		
		//Getting the input file from user
		System.out.print("  Name of Client Information File ==> ");
		String fileName = sc.nextLine();
		
		//Initialising new file scanner object
		Scanner input = new Scanner(new File(fileName));
		
		//Getting the total number of bank accounts from file
		int numberAcc=input.nextInt();
		
		//Initialising new BankAccount object
		BankAccount client[] = new BankAccount[numberAcc];
		
		String name=input.next();
		System.out.println(name);
		
		//Calling setInfo method to populate the client object array
		//with information from the input file
		setInfo(client,name,input,numberAcc);
		
		//Calling the displayInfo method to output the clients initial bank info
		displayInfo(client,numberAcc);
		
		System.out.print("\n\n");
		System.out.println("Account Summary: ");
		
		//Calling the account transaction method to update account based on transactions from file
		accountTransactions(input,client,numberAcc);
		
		//Calling the displayInfo method to output the clients account summary after the transactions
		displayInfo(client,numberAcc);
	}
	
	/*
	 * Populates the object array with initial bank info
	 * Parameters: BankAccount object array, Owner name,
	 * file Scanner object, number of bank accounts
	*/
	public static void setInfo (BankAccount setClient[],String name,Scanner input,int counter){
		
		int i=0;
		String type="";
		int accNo = 0;
		double balance = 0.0;
		
		// while loop to populate the object array
		while(i<counter){
			
			//Getting input from file including type of account, account number and initial balance
			type = input.next();
			accNo = input.nextInt();
			balance = input.nextDouble();
			
			setClient[i] = new BankAccount(accNo , name , balance , type);
			i++;
		}
		
	}
	
	/*
	 * Displays the bank account information using the toString() method
	 * Parameters: BankAccount object array, number of bank accounts as
	 * counter(cntr)
	*/
	public static void displayInfo (BankAccount displayInfo[],int cntr) {
		
		//'for' loop to output the information from the client object array
		for(int i=0;i<cntr;i++){
			
			System.out.println(displayInfo[i].toString());
		}
	} 
	
	/*
	 * Reads the input file and updates the client bank account
	 * based on the transactions indicated in the file
	 * Parameters: file Scanner object, BankAccount object array, 
	 * number of bank accounts as counter(cnt)
	*/
	public static void accountTransactions (Scanner input,BankAccount client[],int cnt){
		
		//'while' loop keeps reading file to the end
		while(input.hasNext()){
			
			//Getting the account number to update info
			int accTrans=input.nextInt();
			int accCount=0;
			
			//'for' loop to search through the records and find the  matching account number
			for(int j=0;j<cnt;j++){
				//checks if the account number from the file matches the corresponding account number in the array
				if(accTrans == client[j].getAccountNumber()){
					accCount = j;
				}
			}
			
			//Getting the transaction type from the file
			String transactionType = input.next();
			
			//if-else block to update client info based on different transaction type
			if(transactionType.equals("charge")){
				
				double originalBalance = client[accCount].getBalance();
				double amount = input.nextDouble();
				double finalBalance = originalBalance - amount;
				client[accCount].setBalance(finalBalance);
				
			}
			
			else if(transactionType.equals("withdrawl")){
				
				double amount = input.nextDouble();
				client[accCount].withdrawl(amount);
				
			}
			
			else if(transactionType.equals("interest")){
				
				double rate = input.nextDouble();
				double principal = client[accCount].getBalance();
				
				double interest = principal*rate*0.01;
				
				double finalBalance = principal + interest;
				client[accCount].setBalance(finalBalance);
		
			}
			
			else if(transactionType.equals("deposit")){
				
				double amount = input.nextDouble();
				client[accCount].deposit(amount);
				
			}
		}
		
	}
}
