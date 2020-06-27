package corecs.matrix;

public class SnakeMatrix_Even_Odd_Col {
	public static void main(String[] args) {

		int[][] inputMatrix = buildMatrix();

		print(inputMatrix);
	}

	public static int[][] buildMatrix() {

		int[][] matrix = { { 1,  2,  3,  4 }, 
						   { 12, 13, 14, 5 }, 
						   { 11, 16, 15, 6 }, 
						   { 10, 9,  8,  7 } 
						 };
		return matrix;
	}

	public static void print(int[][] inputMatrix) {

		for(int curRow = 0 ; curRow < inputMatrix.length ; curRow++) {
			
			if(curRow == 0 || curRow % 2 == 0) {
				
				for(int curCol = 0; curCol < inputMatrix[0].length ; curCol++) {
					System.out.print(inputMatrix[curRow][curCol]);
				}
				
			}else {
				
				for(int curCol = inputMatrix[0].length -1 ; curCol >= 0; curCol--) {
					System.out.print(inputMatrix[curRow][curCol]);
				}
			}
		}
		
	}
}
