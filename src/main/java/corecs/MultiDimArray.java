package corecs;

public class MultiDimArray {

	public static void main(String[] args) {
	
		int[][] arr = {
				{1,11,111},
				{2,22,222}, 
				{3,33,333},
				{4,44,444},
				{5,55,555},
				{6,66,666}
		};
		
		for(int row= 0 ; row < arr.length; row++) {
			System.out.println("row " + row);
			for(int col = 0; col < arr[row].length; col ++) {
				System.out.println("col " + col + " :: " + arr[row][col]);
			}
			
		}
		
	}
}
