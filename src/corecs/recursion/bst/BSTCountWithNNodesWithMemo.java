package corecs.recursion.bst;

public class BSTCountWithNNodesWithMemo {
	
	public static void main(String[] args) {
		long count = how_many_BSTs(3);
		
		System.out.println(count);
	}
	
	
	 // initialize memorise array to max size limit
    static long BST_memorise[] = new long[35];
    
    /*
     * Complete the function below.
     */
    static long how_many_BSTs(int n) {
        // base condition
        if(n <= 1)
           return 1;
           
        if(BST_memorise[n-1] != 0L)
          return BST_memorise[n-1];
           
           
        // evaluate for all left & right sub combo
        long BST = 0L;
        for(int i = 0; i< n; i++) {
            BST += how_many_BSTs(i)*how_many_BSTs(n-i-1);
        }
        BST_memorise[n-1] = BST;
        return BST;

    }

}
