package corecs.arrays.search.substring;

//This code is contributed by nuclode
public class RabinKarpAlgorithm {

	// number of possible characters in the input string 
    public final static int noOfAlphabets = 256;
   
    static void search(String subStrToSearch, String inputString, int primeNo) 
    { 
        int subStrToSearchLength = subStrToSearch.length(); 
        int inputStrLength = inputString.length();
        int hashOfSubStrToSearch = 0; // hash value for pattern 
        int hashOfSlidingWindowInputStr = 0; // hash value for inputString 
        int hash = 1; 
      
        // hash = pow(alphabetSize, subStrToSearchLength-1) % primeNo 
        for (int i = 0; i < subStrToSearchLength-1; i++) {
        	hash = (noOfAlphabets * hash) % primeNo;
        }
             
      
        // Calculate the hash value of :-
        // InputString and 
        // first sliding window of InputString
        for (int i = 0; i < subStrToSearchLength; i++) 
        { 
            hashOfSubStrToSearch = (noOfAlphabets * hashOfSubStrToSearch + subStrToSearch.charAt(i)) % primeNo; 
            hashOfSlidingWindowInputStr = (noOfAlphabets * hashOfSlidingWindowInputStr + inputString.charAt(i)) % primeNo; 
        } 
      
         
        int endOfStartPointer = inputStrLength - subStrToSearchLength;
        // Slide the pattern over text one by one
        for (int startingPointer = 0; startingPointer <= endOfStartPointer; startingPointer++) 
        { 
      
            // Check the hash values of current window of text 
            // and pattern. If the hash values match then only 
            // check for characters on by one 
            if ( hashOfSubStrToSearch == hashOfSlidingWindowInputStr ) 
            { 
                int charMatchCount = 0;
            	/* Check for characters one by one */
                for (int i = 0; i < subStrToSearchLength; i++) 
                { 
                    if (inputString.charAt(startingPointer+i) != subStrToSearch.charAt(i)) {
                    	break;
                    }
                    charMatchCount ++;
                }
                 
                if (charMatchCount == subStrToSearchLength) {
                	System.out.println("Pattern found at index " + startingPointer); 
                }
            } 
      
            // Calculate hash value for next window of InputString and  
            // Remove leading digit, add trailing digit 
            if ( startingPointer < endOfStartPointer ) 
            { 
                // Calculate Hash of New Sliding Window from its Previous Has Value 
            	hashOfSlidingWindowInputStr = (noOfAlphabets * (hashOfSlidingWindowInputStr - inputString.charAt(startingPointer) * hash) 
            									   + inputString.charAt(startingPointer+subStrToSearchLength)) % primeNo; 
      
                // We might get negative value of t, converting it 
                // to positive 
                if (hashOfSlidingWindowInputStr < 0) {
                	hashOfSlidingWindowInputStr = (hashOfSlidingWindowInputStr + primeNo);	
                }
                 
            } 
        } 
    } 
      
    /* Driver program to test above function */
    public static void main(String[] args) 
    { 
        String txt = "hash and re-hash is the key of this algorithm."; 
        String pat = "hash"; 
        int primeNo = 101; // A prime number 
        search(pat, txt, primeNo); 
    } 
}
