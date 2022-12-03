/*
*Name: Kenil C. Shah
*ID: V00903842
*Date: 24 Jan 2018
*Filename: PandI.java
*Details: CSc 110 Assignment 2 part(d)
*/

import java.util.*;
import java.math.*;

public class PandI{
	public static void main(String[] args){
	
	System.out.println("I N T E R E S T   C A L C U L A T O R");
	System.out.println("By: Kenil Shah");
	System.out.println("	January 24, 2018");
	System.out.println("INPUT: ");
		
	//Initaializing new scanner object	
	Scanner sc = new Scanner(System.in);
	
	//Obtaining principal amount from user
	System.out.print("Amount of Loan (in $) ==> ");
	double principal = sc.nextDouble();
	System.out.println();
	
	//Obtaining interest rate from user
	System.out.print("Annual Interest (in %) ==> ");
	double rate = sc.nextDouble();
	System.out.println();
	
	//Copying the value of original principal into another variable
	double originalPrincipal = principal;
	rate=rate/365/100;
	
	// "for" loop to calculate the amount over the year
	for(int i=1;i<=365;i++){
		principal = principal + (principal*rate);
	}
	
	//Rounding the final amount to 2 decimal places
	double amount = Math.round(principal*100.0)/100.0;
	
	// OUTPUT
	System.out.println("Original Principal= " + originalPrincipal);
	System.out.println("Amount owing (1 year later) = " + amount);
	System.out.println("Interest Cost = " + Math.round((amount-originalPrincipal)*100.0)/100.0);
	}
}