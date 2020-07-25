package corecs.arrays.palindrome;



public class LongestPalindromeSubStringFinderV0 {

	public static void main(String[] args) {

		String s = "raceecarr";

		int maxLengthPlaindromeStr = findlongestPalindromeSubString(s);

		System.out.println(maxLengthPlaindromeStr);
	}

	public static int findlongestPalindromeSubString(String s) {

		int maxLength = Integer.MIN_VALUE;

		int l = s.length();

		int maxLengthOddLengthInputStr = Integer.MIN_VALUE;
		int maxLengthEvenLengthInputStr = Integer.MIN_VALUE;

		int leftPointer = 0;
		int rightPointer = 0;

		int maxSofar = 0;

		for (int i = 0; i < l; i++) {

			leftPointer = i;
			rightPointer = i;

			while (leftPointer >= 0 && rightPointer < l && s.charAt(leftPointer) == s.charAt(rightPointer)) {

				maxSofar = rightPointer - leftPointer + 1;

				maxLengthOddLengthInputStr = Math.max(maxSofar, maxLengthOddLengthInputStr);
				
				leftPointer--;
				rightPointer++;

			}

			
			leftPointer = i - 1;
			rightPointer = i;
			maxSofar = 0;

			while (leftPointer >= 0 && rightPointer < l && s.charAt(leftPointer) == s.charAt(rightPointer)) {

				maxSofar = rightPointer - leftPointer + 1;

				maxLengthEvenLengthInputStr = Math.max(maxSofar, maxLengthEvenLengthInputStr);
				
				leftPointer--;
				rightPointer++;

			}

		}

		maxLength = Math.max(maxLengthEvenLengthInputStr, maxLengthOddLengthInputStr);

		return maxLength;

	}
}
