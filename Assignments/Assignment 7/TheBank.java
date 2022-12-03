/*
* Name: Kenil C. Shah
* ID: V00903842
* Date: 4 April 2018
* Filename: TheBank.java
* Details: CSc 110 Assignment 7
*/

import java.io.*;
import java.util.*;

public class TheBank{
	
	/*
	* Main method calls other methods to input bank info,make transactions
	* Output to file and screen after ordering the data
	*/
	public static void main (String [] args) throws FileNotFoundException {

		//Program Introduction
		bankIntro();

		//Load Accounts from file
		BankAccount [] intitalBranch  = loadAccounts();

		// Manage transactions
		BankAccount [] finalBranch = accountTransactions(intitalBranch);
		
		// Sort array of accounts
		BankAccount [] sortedAscend = sortAscending(finalBranch);
		
		//Output updated accounts to file
		fileOutput(sortedAscend);
		
		// Sort array of accounts
		BankAccount [] sortedDescend = sortDescending(finalBranch);
		
		// Output accounts to screen
		screenOutput(sortedDescend);
	}
	
	/*
	* Outputs the into statements on the screen
	* Input: none
	* Returns: none
	*/
	public static void bankIntro() {
		System.out.println("T R A N S A C T I O N   U P D A T I N G");
		System.out.println("\n\n\n");
	}
	
	/*
	* Loads bank account info from a file
	* Input: none
	* Returns: an array of bank accounts
	*/
	public static BankAccount[] loadAccounts() throws FileNotFoundException {

		//Initialize input file containing clients:
		Scanner clientIn = new Scanner(new File("AccountBackUp.dat"));

		//make an array as large as largest possible number of clients
		BankAccount [] clientData = new BankAccount[1000];

		// input all accounts from file & count the number
		int number = 0;
		while (clientIn.hasNextLine()) {
			clientData[number] = new BankAccount();
			clientData[number].setOwnerName(clientIn.next());
			clientData[number].setAccountNumber(clientIn.nextInt());
			clientData[number].setBalance(clientIn.nextDouble());
			number++;
		}

		// copy the client data to an array that is the right size, called returningClients
		BankAccount[] returningClients = new BankAccount[number];
		for (int i = 0; i < number; i++) {
			returningClients[i] = clientData[i];
		}

		return returningClients;
	}
	
	/*
	* Loads transaction info from a file and makes changes to the existing info
	* Input: array of client's bank account data
	* Returns: modified array of bank account info 
	*/
	public static BankAccount[] accountTransactions(BankAccount[] client) throws FileNotFoundException {
		
		//Initialising file scanner object to get transaction details
		Scanner clientIn = new Scanner(new File("TransactionsJanuary.dat"));
		
		//Initialising printstream object to output data to file
		PrintStream clientOut = new PrintStream(new File("error.dat"));
		
		//'while' loop to go through all the data in the file
		while(clientIn.hasNext()){
			
			//Obtaining owner name and account number from the file
			String ownerName = clientIn.next();
			int accountNumber = clientIn.nextInt();
			
			//Going through the records to find matching account number
			int accCount=0;
			
			for(int i=0;i<client.length;i++){
				
				if(accountNumber == client[i].getAccountNumber()){
					
					accCount = i;
				}
			}
			
			//Comparing owner name and account number from file to the pre-existing data in the array
			if(client[accCount].getAccountNumber() == accountNumber && client[accCount].getOwnerName().equals(ownerName)){
					
				//Getting the transaction type from the file
				String transactionType = clientIn.next();
			
				//if-else block to update client info based on different transaction type
				if(transactionType.equals("charge")){
					
					double originalBalance = client[accCount].getBalance();
					double amount = clientIn.nextDouble();
					double finalBalance = originalBalance - amount;
					client[accCount].setBalance(finalBalance);
					
				}
			
				else if(transactionType.equals("withdrawal")){
					
					double amount = clientIn.nextDouble();
					client[accCount].withdrawal(amount);
					
				}
			
				else if(transactionType.equals("interest")){
				
					double rate = clientIn.nextDouble();
					double principal = client[accCount].getBalance();
				
					double interest = principal*rate*0.01;
				
					double finalBalance = principal + interest;
					client[accCount].setBalance(finalBalance);
		
				}
			
				else if(transactionType.equals("deposit")){
				
					double amount = clientIn.nextDouble();
					client[accCount].deposit(amount);
				
				}
				
			}
			
			//If records mismatch, an error log is outputed to a file
			else{
				
				String transactionType = clientIn.next();
				double amount = clientIn.nextDouble();
				clientOut.println("ERROR: Account/name mismatch: "+ownerName+" "+accountNumber);
			}
			
		}
		
		return client;
		
	}
	
	/*
	* Sorts the array of data in ascending order of account number
	* Input: array of bank accounts
	* Returns: sorted array in ascending order of account number
	*/
	public static BankAccount[] sortAscending(BankAccount[] ascend){
		
		BankAccount[] temp = new BankAccount[ascend.length];
		
		//'for' loop to go through all the records
		for(int i=0;i<ascend.length;i++){
			
			int locationMin = i;
			int min = ascend[i].getAccountNumber();
			
			//'for' loop to go through the remaining records to compare each element 
			for (int j = i; j < ascend.length; j++) {
				if (ascend[j].getAccountNumber() < min) {
					
					locationMin = j;
					min = ascend[j].getAccountNumber();
				}
			}
			
			if (locationMin != i) {
				
				//swap
				temp[i] = ascend[i];
				ascend[i] = ascend[locationMin];
				ascend[locationMin] = temp[i];
			}
		}
		
		return ascend;
	}
	
	/*
	* Sorts array of data in descending order of balance
	* Input: array of bank accounts
	* Returns: sorted array in descending order of balance
	*/
	public static BankAccount[] sortDescending(BankAccount[] descend){
		
		BankAccount[] temp = new BankAccount[descend.length];
		
		//'for' loop to go through all the records
		for(int i=0;i<descend.length;i++){
			
			int locationMax = i;
			double max = descend[i].getBalance();
			
			//'for' loop to go through the remaining records to compare each element 
			for(int j=i;j<descend.length;j++){
				if(descend[j].getBalance()>max){
					
					locationMax = j;
					max = descend[j].getBalance();
				}
			}
			
			if(locationMax != i){
				
				//swap
				temp[i] = descend[i];
				descend[i] = descend[locationMax];
				descend[locationMax] = temp[i];
			}
		}
		
		return descend;
	}
	
	/*
	* Outputs an input array in a .dat file
	* Input: an array of bank account sorted in ascending order of account number
	* Returns: none
	*/
	public static void fileOutput(BankAccount[] printData) throws FileNotFoundException{
		
		//Initialising printstream object to output to file
		PrintStream clientOut = new PrintStream(new File("TransactionsFebruary.dat"));
		
		for(int i=0; i<printData.length;i++){
			
			clientOut.println(printData[i].toString());
		}
	}
	
	/*
	* Outputs an input array to the screen
	* Input: an array of bank account sorted in descending order of balance
	* Returns: none
	*/
	public static void screenOutput (BankAccount[] printData){
	
		System.out.println(" C L I E N T   A C C O U N T S");	
		
		//Initialising scanner object to wait for user input before outputing
		Scanner enter = new Scanner(System.in);
		int counter = 1;
		
		//Outputing the first index data
		System.out.println(printData[0].getOwnerName()+"\t"+printData[0].getBalance());
		
		for(int i=1;i<printData.length;i++){
			
			
			System.out.print(printData[i].getOwnerName()+"\t"+printData[i].getBalance());
			counter++;
			
			//if statement to prevent an extra line in the output screen
			if(counter != 20)System.out.println();
			
			//if condition to wait after inputing 20 lines
			if(counter == 20){
				
				enter.nextLine();
				counter = 1;
			}
			
		}
	}
}