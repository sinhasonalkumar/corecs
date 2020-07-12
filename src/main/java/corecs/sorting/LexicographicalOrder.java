package corecs.sorting;

import java.util.HashMap;
import java.util.Map;

public class LexicographicalOrder {

	public static void main(String[] args) {
		
		
//		System.out.println("z".compareTo("a") > 0);
//		System.out.println("z".compareTo("d") > 0);
//		
//		System.out.println("a".compareTo("d") > 0);
//		
//		
//		
//		System.out.println("4".compareTo("3") > 0);
//		
//		System.out.println("3".compareTo("4") > 0);
		
		//System.out.println("qqqq".compareTo("qqq") > 0);
		

		test();

		
	}


	private static void test() {
		String[] arr = { 
				"key1 abcd",
				"key2 zzz",
				"key1 hello",
				"key3 world",
				"key1 hello",
				
		};
		String[] result = solve(arr);
		
		for (String curStr : result) {
			System.err.println(curStr);	
		}
	} 
	
	
    /*
     * Complete the solve function below.
     */
    static String[] solve(String[] arr) {
      
      if(arr.length < 1) {
          return arr;
      }
      
       Map<String,Dto> map = new HashMap<>();
       
       String[] tmp;   
       String key;
       String value;
       Dto storeValue;
       Dto dto = null;
       
       for(String curStr : arr) {
           tmp = curStr.split(" ");
           key = tmp[0];
           value = tmp[1];
           
           if(!map.containsKey(key)) {
               dto = new Dto(value);
               map.put(key,dto);
           }else{
               storeValue = map.get(key);
               storeValue.incrementCount();
               
               if(value.compareTo(storeValue.getValue()) > 0) {
                   storeValue.setValue(value);
               }
               
           }
       }
       String[] result = new String[map.size()];
       int i = 0;
       for(String curKey : map.keySet()) {
           result[i] = curKey + ":" + map.get(curKey);
           i++;
       }
       
       return result;

    }
    
    static class Dto {
           private String value;
           private int count;
           
           public Dto(String value) {
               this.value = value;
               this.count = 1;
           }
           
           public void setValue(String value) {
               this.value = value;
           }
           
           public void incrementCount(){
               this.count ++;
           }
           
           public String getValue(){
               return this.value;
           }
           
           public String toString() {
               return count + ","+value;
           }
           
          
       }






}
