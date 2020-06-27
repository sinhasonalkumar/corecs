package corecs.recursion;

public class FibonacciSeries {

	public static void main(String[] args) {
		int n = 10;
		String fibonacciSeries = fibonacciSeries(n);
		
		System.out.println("\n\n************************Result************************");
		System.out.println("fibonacciSeries of length " + n + " -> " + fibonacciSeries);
		System.out.println("**********************************************************");
	}

	private static String fibonacciSeries(int n) {
		StringBuilder slate;

		if (n == 0) {
			return null;
		} else {
			slate = new StringBuilder();

			if (n == 1) {
				slate.append("0");
				System.out.println("Slate ->  " + slate);
				System.out.println("---------------------------");
			} else {
				slate.append("0").append("1");
				System.out.println("Slate -> calling recursion now " + slate);
				System.out.println("---------------------------");
				slate.append(helper(slate, 0, 1, 2, n, -1));
			}
		}

		return slate.toString();
	}

	private static StringBuilder helper(StringBuilder slate, int privious, int current, int i, int n, int tmp) {

		if (i == n) {
			System.out.println("Base Case : Slate -> " + slate);
			System.out.println("---------------------------");
			return slate;
		}

		tmp = current;
		current = current + privious;
		privious = tmp;
		slate.append(current);
		i++;

		System.out.println("Slate -> " + slate);

		System.out.println("---------------------------");

		return helper(slate, privious, current, i, n, -1);
	}
}
