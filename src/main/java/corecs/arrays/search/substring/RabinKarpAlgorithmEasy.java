package corecs.arrays.search.substring;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgorithmEasy {

	private static final int PRIME_NO = 101;	

	public static List<Integer> searchSubString(String inputString, String subStringPattern) {

		List<Integer> subStrPatternFoundStartIndexList = new ArrayList<Integer>();

		int slidingWindowLength = subStringPattern.length();

		int leftPointer = 0;

		int rightPointer = slidingWindowLength - 1;

		String curSlidingWindowInputString = inputString.substring(leftPointer, rightPointer + 1);

		double hashOfSubStringPattern = calulateHash(subStringPattern);
		double hashOfSlidingWindowInputString = calulateHash(curSlidingWindowInputString);

		String nextSlidingWindowInputString;

		boolean slidingWindowFinshed = false;

		while (!slidingWindowFinshed) {

			if (hashOfSubStringPattern == hashOfSlidingWindowInputString) {

				if (checkEqual(curSlidingWindowInputString, subStringPattern)) {
					subStrPatternFoundStartIndexList.add(leftPointer);
				}

			}

			leftPointer++;
			rightPointer++;

			if (rightPointer < inputString.length()) {
				nextSlidingWindowInputString = inputString.substring(leftPointer, rightPointer + 1);

				hashOfSlidingWindowInputString = calulateNewHash(curSlidingWindowInputString,
																 hashOfSlidingWindowInputString, 
																 nextSlidingWindowInputString);

				curSlidingWindowInputString = nextSlidingWindowInputString;
			} else {
				slidingWindowFinshed = true;
			}

		}

		return subStrPatternFoundStartIndexList;
	}

	public static boolean checkEqual(String s1, String s2) {

		// assumption is s1 and s2 will always be of same length equal to slidigWindow
		// Size
		int strLength = s1.length();

		for (int i = 0; i < strLength; i++) {

			if (s1.charAt(i) != s2.charAt(i)) {
				return false;
			}
		}

		return true;
	}

	public static double calulateHash(String str) {

		double hash = 0;

		for (int i = 0; i < str.length(); i++) {

			hash = hash + str.charAt(i) * Math.pow(PRIME_NO, i);
		}

		return hash;
	}

	public static double calulateNewHash(String prevStr, double prevHash, String newStr) {

		char charRemoved = prevStr.charAt(0);

		// or prevStr.length() -1 as both prevStr and prevStr are same which is length
		// of sliding Window
		char newCharAdded = newStr.charAt(newStr.length() - 1);

		double newHash = prevHash - charRemoved;

		newHash = newHash / PRIME_NO;

		newHash = newHash + newCharAdded * Math.pow(PRIME_NO, newStr.length() - 1);

		return newHash;

	}
	
	public static void main(String[] args) {

		String inputString = "hash and re-hash is the key of this algorithm.";
		String subStringPattern = "hash";

		List<Integer> result = searchSubString(inputString, subStringPattern);

		result.forEach(r -> System.out.println("Substring pattern " + subStringPattern + " found at Index -> " + r));
	}
}
