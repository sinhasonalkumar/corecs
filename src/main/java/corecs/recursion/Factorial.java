package corecs.recursion;

public class Factorial {

	public static void main(String[] args) {
		calculateFactorial(10);
	}

	public static void calculateFactorial(int number) {

		System.out.println("\nHelper Method Called -> Input -> " + number);

		int factorial = helper(number);

		System.out.println("\nFinal Result -> factorial of " + number + " : " + factorial);
	}

	public static int helper(int number) {

		if (number == 1) {

			System.out.println("\nEnter BaseCase -> helper(" + number + ")");
			System.out.println("\nExit BaseCase -> helper(" + number + ") -> Result -> " + number);

			return 1;
		}

		System.out.println("\nEnter Recursion -> " + number + " *  helper(" + (number - 1) + ")");

		int result = number * helper(number - 1);

		System.out.println("\nExit Recursion -> helper(" + number + ") -> "+ number + " *  helper(" + (number - 1) + ")"  + " = " + result);

		return result;
	}
}
