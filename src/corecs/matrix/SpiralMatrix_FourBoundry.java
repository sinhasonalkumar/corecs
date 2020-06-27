package corecs.matrix;

public class SpiralMatrix_FourBoundry {

	public static void main(String[] args) {

		int[][] inputMatrix = buildMatrix();

		print(inputMatrix);
	}

	public static int[][] buildMatrix() {

		int[][] matrix = { { 1, 2, 3, 4 }, 
						   { 12, 13, 14, 5 }, 
						   { 11, 16, 15, 6 }, 
						   { 10, 9, 8, 7 } 
						 };
		return matrix;
	}

	public static void print(int[][] inputMatrix) {

		helper(inputMatrix, 0,inputMatrix.length, 0, inputMatrix[0].length);
	}

	public static void helper(int[][] matrix, int startRowIdx, int endRowIdx, int startColIdx, int endColIdx) {
		
		//BaseCondition
		if(endRowIdx < 0 && endColIdx < 0) {
			return;
		}
		
		for (int curCol = startRowIdx ; curCol < endColIdx ; curCol++) {
			System.out.print(matrix[startRowIdx][curCol]);
		}
		
		

		for (int curRow = startRowIdx + 1; curRow < endRowIdx ; curRow++) {
			System.out.print(matrix[curRow][endColIdx - 1]);
		}
		
		

		for (int curCol = endColIdx - 2; curCol >= startColIdx ; curCol--) {
			System.out.print(matrix[endRowIdx - 1][curCol]);
		}
		
		

		for (int curRow = endRowIdx - 2; curRow >= startRowIdx + 1; curRow--) {
			System.out.print(matrix[curRow][startColIdx]);
		}
		
		//Recursion
		helper(matrix, startRowIdx+1, endRowIdx-1, startColIdx+1, endColIdx-1);

	}

}
