/*
*Name: Kenil C. Shah
*ID: V00903842
*Date: 26 Jan 2018
*Filename: Totem.java
*Details: CSc 110 Assignment 2 part(c)
*/

import java.util.*;

public class Totem{
	public static void main(String[] args){
		
		//Initaializing new scanner object	
		Scanner sc = new Scanner(System.in);
		
		//Initaializing new random object	
		Random rnd = new Random();
		
		System.out.println("T O T E M  G E N E R A T O R\n");
		System.out.println("By: Kenil Shah");
		System.out.println("	January 26,2018");
		
		//Obtaining the number of figures from the user
		System.out.print("How many creatures? ==> ");
		int numFigs = sc.nextInt();
		
		System.out.println();
		//For loops to print multiple totems
		for(int i=1;i<=numFigs;i++){
			int choice = rnd.nextInt(3) + 1 ;
		
			System.out.println();
			if (choice == 1) eagle();
			if (choice == 2) whale(); 
			if (choice == 3) human();
		}
	}
	
	//Method to create ASCII art of an eagle
	public static void eagle(){
		
		System.out.println("                     _--_");
		System.out.println("                    /   -)");
		System.out.println("                ___/___|___");
		System.out.println("      ____-----///|     ||||~=---_____");
		System.out.println("    //~/////////~/|     |//|||\\\\\\\\\\\\\\\\\\\\");
		System.out.println("  /////////////////|   |/////|\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println(" /////~~~~~~~~~~~~\\ |.||/~~~~~~~~~~~~`\\\\\\\\\\ ");
		System.out.println("//                /\\\\|\\\\                  \\\\");
		System.out.println("                 ///W^\\W\\");
		System.out.println("                ////|||\\\\\\");
		System.out.println("                ~~~~~~~~~~");
	}
	
	//Method to create ASCII art of a whale
	public static void whale(){
		
		System.out.println(" .--------'```'----....,,______             _,");
		System.out.println("|                               `-------._./  \\");
		System.out.println("|                                             <");
		System.out.println("\\          .-'`'-.                             `");
		System.out.println(" \\          -.o_.     _                 -'`\\   /");
		System.out.println("  ``'--.._.-=-._    .'  \\        _,,--'`    ._(");
		System.out.println(" (^^^^^^^`___    '-. |    \\  ,,.-'");
		System.out.println("  ````````   `'--..___\\    |`");
		System.out.println("                      `-.,'");
	}
	
	//Method to create ASCII art of a human
	public static void human(){
		
		System.out.println("     ////|||\\\\\\\\");
		System.out.println("    //// ^ ^ \\\\\\\\");
		System.out.println("    ||/  @ @  \\||");
		System.out.println("    ||    \"    ||");
		System.out.println("    ||\\   -   /||");
		System.out.println("    ~~ `). .(' ~~");
		System.out.println("   /---'|   |---\\");
		System.out.println(" /'  ,  `\\-/'. ,  '\\");
		System.out.println("(   \\ |.  ..  | /   )");
		System.out.println(" \\  _\\|  .  . |/_  /");
		System.out.println("  `(  >.  .   <  )'");
		System.out.println("    \" |  .  . | \"");
		System.out.println("      |  .    |");
		System.out.println("      |    .  |");
		System.out.println("      | .    .|");
		System.out.println("      |%%%%%%%|");
		System.out.println("      __|#|#|__");
		System.out.println("     (____|____)");
	}
}