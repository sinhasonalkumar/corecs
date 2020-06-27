package corecs.recursion.plaindrome;

public class PalindromeFinder {

	public static boolean isPalindrome(String s) {
		
		boolean result = true;
		
		char[] arr = s.toCharArray();
		
		int mid = (arr.length -1)/2;
		
		for(int i= 0, l=arr.length -1 ; i <= mid ; i++, l--) {
			
			if(arr[i] != arr[l]) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String s = "aabaa";
		System.out.println("isPalindrome -> " + isPalindrome(s));
	}
}
