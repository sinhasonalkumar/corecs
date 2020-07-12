package corecs.sorting;

public class DutchFlagSort {

	public static void main(String[] args) {

		char[] balls = { 'G', 'B', 'R' };

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
					tmp = balls[runningGreenPointer];
					balls[runningGreenPointer] = balls[leftRedPointer];
					balls[leftRedPointer] = tmp;

					runningGreenPointer++;
					leftRedPointer++;
				} else {
					if (balls[runningGreenPointer] == 'B') {
						tmp = balls[runningGreenPointer];
						balls[runningGreenPointer] = balls[rightBluePointer];
						balls[rightBluePointer] = tmp;

						rightBluePointer--;
					}
				}
			}

		}

	}

}
