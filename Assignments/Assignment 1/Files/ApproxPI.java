/*
*Name: Kenil C. Shah
*ID:V00903842
*Date: 16 Jan 2018
*Filename: ApproxPi.java
*Details: CSc 110 Assignment 1 part(c)
*/

//The class will implement a program to approximate the value of pi

public class ApproxPI{
	public static void main(String[] args){
		
		double nextTerm=1;
		double denominator=1;
		double series=0;
		
		for(int i=0;i<400;i++){
			
			series=series+nextTerm/denominator;
			denominator=denominator+2;
			nextTerm=nextTerm*-1;
			
		}
		
		series=series*4;
		System.out.println("The approximate value of PI is: " + series);
		
		}
		
	}
	
}