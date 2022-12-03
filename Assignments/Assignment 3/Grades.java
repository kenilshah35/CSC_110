/*
*Name: Kenil C. Shah
*ID: V00903842
*Date: 9 Feb 2018
*Filename: Grades.java
*Details: CSc 110 Assignment 3 
*/

import java.util.*;

public class Grades{
	
	//The main method which calls on methods - percentage, weightedAvg, letterGrade to calculate the weighted grade for a course and print out the grade 
	public static void main(String[] args){
		
		//Initialising a new scanner object
		Scanner sc = new Scanner(System.in);
		
		System.out.println("C O U R S E  G R A D E  C A L C U L A T O R");
		System.out.println(" Purpose: Calculate the weighted grade for a student in a course");
		System.out.println("    Inputs: Assignment, Lab and Exam grades");
		
		//Obtaining the minimum grade to pass for final exam 
		System.out.print("\nPassing Grade for Final ==> ");
		int passFinal = sc.nextInt();
		
		//Calling percentage method to calculate total percentage of input types(Assignment,Lab,Exams)
		double assignmentPercent = percentage(sc , 7 , "Assignment", 10);
		double labPercent = percentage(sc , 10 , "Lab", 1);
		double midtermPercent = percentage(sc, 2 , "Midterm", 100);
		double finalPercent = percentage(sc , 1 , "Final Exam", 100);
		
		/*Condition to check if student passed the final exam*/
		//if failed outputs 49 as grade and gives an F
		if(finalPercent < passFinal){
			System.out.println("\nGrade = 49.00  F");
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
			String letterGrade = letterGrade(sumWgrade);
			
			//OUTPUT
			System.out.printf("\nGrade = %5.2f",sumWgrade);
			System.out.println("  "+letterGrade);
		}
		
	}
	
	/*The percentage method which passes a scanner object, number of inputs to obtain , the title and the maximum marks
	  and returns the percentage as a double value*/
	public static double percentage(Scanner in, int count , String title, int maxMarks ){
		
		System.out.println("\nInput " + title + "(maximum " + maxMarks + "):");
		
		double individualGrade = 0 , sum = 0;
		
		//Initialising 'for' loop to obtain individual marks 
		for(int i=1;i<=count;i++){
			
			System.out.print("#" + i + "==>");
			individualGrade = in.nextDouble();
			
			// Initialising a 'do while' loop to prevent incorrect marks input by the user
			do{
				
				//If condition to check whether to prompt user for correct input
				if(individualGrade > maxMarks || individualGrade < 0){
					System.out.println("  Incorrect input, try again");
					System.out.print("#" + i + "==>");
					individualGrade = in.nextDouble();
				}
				
			}while(individualGrade > maxMarks || individualGrade < 0);
			
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
	
	//The letterGrade method to find a  letter grade to the corresponding numeric grade
	public static String letterGrade (double total){
		
		String grade = "";
		
		//Blocks of conditional statements to find letter grade
		if(total >= 90){
			grade = "A+";
		}
		
		else if(total >=85 && total <= 89){
			grade = "A";
		}
		
		else if(total >=80 && total <= 84){
			grade = "A-";
		}
		
		else if(total >= 77 && total <= 79){
			grade = "B+";
		}
		
		else if(total >= 73 && total <= 76){
			grade = "B";
		}
		
		else if(total >= 70 && total <= 72){
			grade = "B-";
		}
		
		else if(total >= 65 && total <= 69){
			grade = "C+";
		}
		
		else if(total >= 60 && total <= 64){
			grade = "C";
		}
		
		else if(total >= 50 && total <= 59){
			grade = "D";
		}
		
		else{
			grade = "F";
		}
		
		return grade;
	}
}
