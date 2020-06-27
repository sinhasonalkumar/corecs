package corecs.recursion;

public class FactorialV2 {

	public static void main(String[] args) {
		calulateFactorial(5);
		
	}

	public static int calulateFactorial(int n) {
		return helper(n, n - 1);
	}

	public static int helper(int slate, int i) {

		System.out.println("\n slate = " + slate + ", i = " + i );
		
		if (i == 1) {
			System.out.println("\n Base Case -> Slate = " + slate);
			return slate;
		}

		slate = slate * i;
		i--;
		
		System.out.println("\n Recursion -> new_slate = slate * i = " + slate + ", new_i = i-1 = " + i);
		
		System.out.println("\n -------------------------------------------------- ");

		return helper(slate, i);
	}
}
