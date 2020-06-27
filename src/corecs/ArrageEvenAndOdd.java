package corecs;

public class ArrageEvenAndOdd {

	public static void main(String[] args) {
		
		int[] inputArr = {1, 2, 3, 4};
		int[] arragedEvenOdd = solve(inputArr);
		
		for (int i : arragedEvenOdd) {
			System.out.println(i);
		}
	}


    /*
     * Complete the function below.
     */
    static int[] solve(int[] arr) {
        return arrangeEvenOdd(arr, 0, arr.length -1);
    }
    
    private static boolean isEvenNo(int n) {
        return (n%2) == 0;
    }
    
    private static int[] arrangeEvenOdd(int[] arr, int start, int end) {
        
        int randomIndex = end/2;
                          
        int piviotNo = arr[randomIndex];
        
        if(isEvenNo(piviotNo)) {
            
            arr[randomIndex] = arr[start];
            arr[start] = piviotNo;
            int evenNoPointer = start;
            int oddNoPointer = start + 1;
            int tmp;
        
            while(oddNoPointer <= end) {
                    if(isEvenNo(arr[oddNoPointer])) {
                        evenNoPointer ++;
                        tmp = arr[evenNoPointer];
                        arr[evenNoPointer] = arr[oddNoPointer];
                        arr[oddNoPointer] = tmp;
                    }
                    oddNoPointer ++;
                }
                arr[start] = arr[evenNoPointer];
                arr[evenNoPointer] = piviotNo;
                
            }else{
                arr[randomIndex] = arr[end];
                arr[end] = piviotNo;
                int evenNoPointer = end - 1;
                int oddNoPointer = end;
                int tmp;
        
                while(evenNoPointer >= start) {
                        if(!isEvenNo(arr[evenNoPointer])) {
                            oddNoPointer -- ;
                            tmp = arr[oddNoPointer];
                            arr[oddNoPointer] = arr[evenNoPointer];
                            arr[evenNoPointer] = tmp;
                        }
                        evenNoPointer --;
                    }
                    
                    arr[end] = arr[oddNoPointer];
                    arr[oddNoPointer] = piviotNo;
            }
            
        return arr;    
    }




}
