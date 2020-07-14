package corecs.sorting.quicksort;

public class DutchFlagSort {

	public static void main(String[] args) {

		char[] balls = { 'G','B','R','B','G','R','B','B' };
		//char[] balls = { 'R','B','R','B','G','R','B','B' };

		dutch_flag_sort(balls);

		for (char c : balls) {
			System.out.print(c);
		}
	}

	public static void dutch_flag_sort(char[] balls) {
		// There are a total of 2 red, 4 green and 2 blue balls. In this order they
		// appear in the correct output.

		int leftRedPointer = 0;
		int runningGreenPointer = 0;
		int rightBluePointer = balls.length - 1;

		char pivotColor = 'G';

		char tmp;

		while (runningGreenPointer <= rightBluePointer) {

			if (balls[runningGreenPointer] == 'G') {
				runningGreenPointer++;
			} else {
				if (balls[runningGreenPointer] == 'R') {
					
					swap(balls, runningGreenPointer, leftRedPointer);
					
					runningGreenPointer++;
					leftRedPointer++;
					
				} else {
					if (balls[runningGreenPointer] == 'B') {
						
						swap(balls, runningGreenPointer, rightBluePointer);

						rightBluePointer--;
					}
				}
			}

		}

	}
	
	public static void swap(char[] arr, int index1, int index2) {
		
		char tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
		
	}

}
