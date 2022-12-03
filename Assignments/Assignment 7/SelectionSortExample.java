// Title: Selection Sort Example
// Author: LillAnne Jackson July 2011
// Purpose: to demonstrate an implementation of the Selection Sort example
//

public class SelectionSortExample {
	public static void main(String args[]) {

		// An array for testing
		int [] sampleData = {31, 32, 35, 46, 21, 64, 78, 32, 21, 41, 42, 56, 72, 42, 62, 34};
		printArray(sampleData);

		// Sort and output
		selectionSort(sampleData);
		printArray(sampleData);
	}

	public static void printArray (int [] data) {
		for (int i =0; i < data.length; i++) {
			System.out.print(data[i] + " ");
			if (i%5 == 0) System.out.println();
		}
		System.out.println("\n\n");
	}

	public static void selectionSort(int[] data) {

		for (int i = 0; i < data.length; i ++) {

			//first element is assumed (initially) to be minimum
			int locationMin = i;
			int min = data[i];

			//now find actual minimum
			for (int j = i; j < data.length; j++) {
				if (data[j] < min) {
					locationMin = j;
					min = data[j];
				}
			}

			if (locationMin != i) {
				//swap
				int swap = data[i];
				data[i] = data[locationMin];
				data[locationMin] = swap;
			}
		}
	}
}
