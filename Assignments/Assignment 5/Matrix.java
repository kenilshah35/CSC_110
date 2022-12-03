/*
*Name: Kenil C. Shah
*ID: V00903842
*Date: 2 March 2018
*Filename: Matrix.java
*Details: CSc 110 Assignment 5
*/

import java.util.*;
import java.io.*;

/*
   The Class below will take input from a file: MatrixIn.txt
   Perform few matrix arithematics
   Output the result to the file: MatrixResult.txt
*/
public class Matrix{
	
	/*
	  The main method which calls methods:-
	  getMatrix, add, subtract, scalorMultiply,
	  dot and outputMatrix 
	*/
	public static void main (String[] args)throws FileNotFoundException{
		
		//Initialising new file scanner object
		Scanner input = new Scanner(new File("MatrixIn.txt"));
		
		//Initialising new printstream object to output to file
		PrintStream output = new PrintStream(new File("MatrixResult.txt"));
		
		//Calling getMatrix method to form matrix A,B,D by reading from fileand also getting scalor value of c
		int[][] matrixA= getMatrix(input);
		int[][] matrixB=getMatrix(input);
		int scalorC = input.nextInt();
		int[][] matrixD= getMatrix(input);
		
		//Calling add method to perform matrix addition on A and B
		int[][] matrixAplusB = add(matrixA,matrixB);
		
		//Calling subtract method to perform matrix subtraction on A and B
		int[][] matrixAminusB = subtract(matrixA,matrixB);
		
		//Calling scalorMultiply method to multiply scalor c to matrix A
		int[][] scalorA = scalorMultiply(scalorC,matrixA);
		
		//Calling dot method to perform matrix multiplication on A and D
		int[][] matrixAdotD = dot(matrixA,matrixD);
		
		//Terminal Output
		System.out.println("MATRIX ARITHMETIC\n");
		System.out.println("Inputting Matrices A, B and D and scalar c . . . . . .");
		System.out.println(". . . . Writing result to file: MatrixResult.txt");
		
		//File Output
		output.println("A =");
		outputMatrix(matrixA,output);
		output.println("B =");
		outputMatrix(matrixB,output);
		output.println("c = "+scalorC);
		output.println("D = ");
		outputMatrix(matrixD,output);
		output.println("A + B =");
		outputMatrix(matrixAplusB,output);
		output.println("A - B =");
		outputMatrix(matrixAminusB,output);
		output.println("c A =");
		outputMatrix(scalorA,output);
		output.println("A dot D =");
		outputMatrix(matrixAdotD,output);
		
	}
	
	/*
	  getMatrix method to read
	  input from file and organise
	  into a matrix using two-dimension arrays
	*/
	public static int[][] getMatrix(Scanner inFile){
		
		int rows = inFile.nextInt();
		int cols = inFile.nextInt();
		
		int[][] matrixGeneral = new int[rows][cols];
		
		//nested for loop to store values from file in matrix form using arrays
		for(int i=0;i<rows;i++){
			
			for(int j=0;j<cols;j++){
				matrixGeneral[i][j] = inFile.nextInt();
			}
		}
		
		return matrixGeneral;
	}
	
	/*
	  add method which accepts two arrays as parameters
	  and performs matrix addition
	*/
	public static int [][] add(int[][] one, int[][] theOther){
		
		int[][] matrixAdd = new int[one.length][one[0].length];
		
		//nested for loop to add two matrices
		for(int i=0;i<one.length;i++){
			
			for(int j=0;j<one[i].length;j++){
				matrixAdd[i][j] = one[i][j] + theOther[i][j];
			}
		}
		
		return matrixAdd;
	}
	
	/*
	  subtract method which accepts two arrays as parameters
	  and performs matrix subtraction
	*/
	public static int [][] subtract(int[][] one, int[][] theOther){
		
		int[][] matrixSub = new int[one.length][one[0].length];
		
		//nested for loop to subtract two matrices
		for(int i=0;i<one.length;i++){
			
			for(int j=0;j<one[i].length;j++){
				matrixSub[i][j] = one[i][j] - theOther[i][j];
			}
		}
		
		return matrixSub;
	}
	
	/*
	  scalorMultiply method which accepts an int and array as parameters
	  and performs scalor multiplication on the matrix
	*/
	public static int [][] scalorMultiply(int scalor, int[][] matrix){
		
		int[][] scalorMatrix = new int[matrix.length][matrix[0].length];
		
		//nested for loop to perform scalor multiplication
		for(int i=0;i<matrix.length;i++){
			
			for(int j=0;j<matrix[0].length;j++){
				scalorMatrix[i][j] = scalor * matrix[i][j];
			}
		}
		
		return scalorMatrix;
	}
	
	/*
	  dot method which accepts two arrays as parameters
	  and performs matrix multiplication
	*/	
	public static int [][]dot(int[][] one, int[][] theOther){
		
		int[][] matrixDot = new int[one.length][theOther[0].length];
		
		//nested for loops of 3 loops to perform matrix multiplication
		for(int i=0;i<one.length;i++){
			
			for(int j=0;j<theOther[0].length;j++){
				
				for(int k=0;k<one[0].length;k++){
					matrixDot[i][j] += one[i][k]* theOther[k][j];
				}
			}
		}
		
		return matrixDot;
	}
	
	/*
	  outputMatrix method which accepts an array and printstream object as parameters
	  and outputs the array matrix into a file
	*/
	public static void outputMatrix(int[][] matrix, PrintStream outFile){
		
		for(int i=0;i<matrix.length;i++){
			
			for(int j=0;j<matrix[i].length;j++){
				
				outFile.print("\t"+matrix[i][j]);
			}
			outFile.println();
		}
		
	}
}