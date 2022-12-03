/*
*Name: Kenil C. Shah
*ID: V00903842
*Date: 23 Feb 2018
*Filename: FileGrades.java
*Details: CSc 110 Assignment 4 
*/

import java.util.*;
import java.io.*;

/*This class take input from a file and 
  calculates grade for multiple students
  in a course*/
public class FileGrades{
	
	//The main method which calls on methods - percentage, weightedAvg, letterGrade to calculate the weighted grade for a course and print out the grade 
	public static void main(String[] args)throws FileNotFoundException{
		
		//Initialising a new scanner object
		Scanner sc = new Scanner(System.in);
		
		//Initialising scanner object for file
		Scanner input = new Scanner(new File ("scores5.dat"));
		
		System.out.println("C O U R S E   G R A D E   C A L C U L A T O R");
		System.out.println("    Purpose: Calculates the weighted grade for students in a course");
		System.out.println("    Inputs: The Assignment, Lab and Exam grades for students in a course");
		
		//Obtaining the minimum grade to pass for final exam 
		System.out.print("\nPassing Grade for Final ==>  ");
		int passFinal = sc.nextInt();
		System.out.println("\nFILE INPUT being received . . . .\n");
			
		//Initialising integer counter
		int apluscntr=0;
		int acntr=0;
		int aminuscntr=0;
		int bpluscntr=0;
		int bcntr=0;
		int bminuscntr=0;
		int cpluscntr=0;
		int ccntr=0;
		int dcntr=0;
		int fcntr=0;
		
		//while loop for multiple students' grade
		while(input.hasNext()){
			
			String id = input.next();
			//String newid = Integer.toString(id);
			String finalid = id.substring(2);
				
			//Calling percentage method to calculate total percentage of input types(Assignment,Lab,Exams)
			double assignmentPercent = percentage(input, 7 , "Assignment", 10);
			double labPercent = percentage(input, 10 , "Lab", 1);
			double midtermPercent = percentage(input, 2 , "Midterm", 100);
			double finalPercent = percentage(input, 1 , "Final Exam", 100);
				
			String lettergrade;
			/*Condition to check if student passed the final exam*/
			//if failed outputs 49 as grade and gives an F
			if(finalPercent < passFinal){
				lettergrade = "F";
				System.out.println(finalid + ": Grade: 49.00 F");
			}
		
			//If passes calculates the weighted grade for each input types(Assignment,Lab,Exams) and outputs appropriate grades
			else{
		
				//Calling weightedGrade method to calculte the weighted grade for each input types(Assignment,Lab,Exams)
				double wgradeAss =  weightedGrade(21.0, assignmentPercent);
				double wgradeLab =  weightedGrade(5.0, labPercent);
				double wgradeMT = weightedGrade(32.0, midtermPercent);
				double wgradeFinal =  weightedGrade(42.0, finalPercent);
			
				//Adding all grades to get the total grade for the course
				double sumWgrade = wgradeAss + wgradeLab + wgradeMT + wgradeFinal;
			
				//Calling letterGrade method to find the letterGrade of the corresponding numeric grade
				lettergrade = letterGrade(sumWgrade);
			
				//OUTPUT
				System.out.print(finalid);
				System.out.printf(": Grade: %5.2f ",sumWgrade);
				System.out.println(""+lettergrade);
			}
				
			//if-else block to count number of grades 
			if(lettergrade.equals("A+"))apluscntr++;
			else if(lettergrade.equals("A"))acntr++;
			else if(lettergrade.equals("A-"))aminuscntr++;
			else if(lettergrade.equals("B+"))bpluscntr++;
			else if(lettergrade.equals("B"))bcntr++;
			else if(lettergrade.equals("B-"))bminuscntr++;
			else if(lettergrade.equals("C+"))cpluscntr++;
			else if(lettergrade.equals("C"))ccntr++;
			else if(lettergrade.equals("D"))dcntr++;
			else if(lettergrade.equals("F"))fcntr++; 
				
		}
			
		//Outputing summary of grades of students in the course
		System.out.println("\nGrade  Number Receiving Grade");
		System.out.println("A+      "+apluscntr);
		System.out.println("A       "+acntr);
		System.out.println("A-      "+aminuscntr);
		System.out.println("B+      "+bpluscntr);
		System.out.println("B       "+bcntr);
		System.out.println("B-      "+bminuscntr);
		System.out.println("C+      "+cpluscntr);
		System.out.println("C       "+ccntr);
		System.out.println("D       "+dcntr);
		System.out.println("F       "+fcntr);
	
	}
	
	/*The percentage method which passes a scanner object, number of inputs to obtain , the title and the maximum marks
	  and returns the percentage as a double value*/
	  
	public static double percentage(Scanner infile, int count , String title, int maxMarks ){
		
			double individualGrade = 0 , sum = 0;
		
			//Initialising 'for' loop to obtain individual marks 
			for(int i=1;i<=count;i++){
			
				individualGrade = infile.nextDouble();
			
				//Adding all the marks and storing it in 'sum'
				sum += individualGrade;
			}
		
			//Calculating the total percentage of a specific input type(Assignment,Lab,Exams)
			double percentage = (sum/(maxMarks * count)) * 100;

			return percentage;
	
	}
	
	//The weightedGrade method to calculate the weighted grade for a specific input type(Assignment,Lab,Exams)
	public static double weightedGrade (double weight , double marks){
		
		//Calculates the weighted grade for a specific input type(Assignment,Lab,Exams)
		double weightedGrade = marks * (weight/100);
		
		return weightedGrade;
	}
	
	/*The letterGrade method to find a  letter grade to the corresponding numeric grade
	  Credited to L.Jackson for the method below*/
	public static String letterGrade (double grade){
		
		String letter;

		if (grade < 49.5) letter = "F";
		else if (grade < 59.5) letter = "D";
		else if (grade < 64.5) letter = "C";
		else if (grade < 69.5) letter = "C+";
		else if (grade < 72.5) letter = "B-";
		else if (grade < 76.5) letter = "B";
		else if (grade < 79.5) letter = "B+";
		else if (grade < 84.5) letter = "A-";
		else if (grade < 89.5) letter = "A";
		else letter = "A+";

		return letter;
	}
}
