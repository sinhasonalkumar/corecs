package corecs;

public class MergeKArrays {

	
	public static void main(String[] args) {
		int[][] inputArray = {
				{1, 3, 5, 7},
				{2, 4, 6, 8},
				{0, 9, 10, 11}
				
		};
		
		int[] mergeArrays = mergeArrays(inputArray);
		
		for (int i = 0; i < mergeArrays.length; i++) {
			System.out.println(mergeArrays[i]);
		}
	}
	
    /*
     * Complete the mergeArrays function below.
     */
    static int[] mergeArrays(int[][] arr) {
        if(arr.length == 0) {
            return new int[1];
        }    
       
        int[] result = arr[0];
        
        int sortOrder;
        
        if(arr.length > 0) {
            
            sortOrder = findSortOrder(arr);
            
             for(int row = 1 ; row < arr.length ; row ++) {
                 
                result = mergeTwoArrays(result, arr[row],sortOrder);  
                
             }
        }
        
        return result;
    }
    
    private static int findSortOrder(int[][] arr) {
        int result = 1;
    
        for(int row = 0 ; row < arr.length ; row++ ) {
            result  = findSortOrder(arr[row]);
            if(result != -1){
                return result;
            } 
        }
        
        return result;
        
    }
    
    private static int findSortOrder(int[] arr) {
       
        for(int i = 0 ; i+1 < arr.length  ; i++) {
           if(arr[i] < arr[i+1]) {
                    return 1;
            }else{
                if(arr[i] > arr[i+1]){
                    return 0;
                }  
            }  
            
        }
        
        return -1;
        
    }
    
    private static int[] mergeTwoArrays(int[] arr1, int[] arr2, int sortOrder) {
        int[] marr = new int[arr1.length + arr2.length];
        int fap = 0;
        int sap = 0;
        int map = 0;
        
        if(sortOrder == 1){
            while(fap < arr1.length && sap < arr2.length) {
            if(arr1[fap] < arr2[sap]) {
                marr[map] = arr1[fap];
                fap++;
            }else{
                marr[map] = arr2[sap];
                sap++;
            }
            map++;
            }    
        }else{
            while(fap < arr1.length && sap < arr2.length) {
            if(arr1[fap] > arr2[sap]) {
                marr[map] = arr1[fap];
                fap++;
            }else{
                marr[map] = arr2[sap];
                sap++;
            }
            map++;
            }
        }
        
        
        while(fap < arr1.length) {
             marr[map] = arr1[fap];
             fap++;
              map++;
        }
        
        while(sap < arr2.length) {
            marr[map] = arr2[sap];
            sap++;
             map++;
        }
        
        return marr;
        
    }



}
