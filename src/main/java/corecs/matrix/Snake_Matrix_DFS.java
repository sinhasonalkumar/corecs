package corecs.matrix;

import java.util.ArrayList;
import java.util.List;

public class Snake_Matrix_DFS {

	public static void main(String[] args) {

		int[][] inputMatrix = buildMatrix();

		print(inputMatrix);
	}

	public static int[][] buildMatrix() {

		int[][] matrix = { 
							{ 1,  2,  3,  4 }, 
							{ 12, 13, 14, 5 }, 
							{ 11, 16, 15, 6 }, 
							{ 10, 9,  8,  7 } 
						 };
		return matrix;
	}
	
	public static void print(int[][] inputMatrix) {
		
		int totalRows = inputMatrix.length;
		int totalCols = inputMatrix[0].length;
		
		List<String> visitedCells = new ArrayList<String>();
		
		int curCellX = 0;
		int curCellY = 0;
		
		// E W N S
		int[] neighbourX = {0, 0 , -1 , 1};
		int[] neighbourY = {1, -1 , 0 , 0};
		
		helper(inputMatrix, totalRows, totalCols, neighbourX, neighbourY, visitedCells, curCellX, curCellY);
		
				
	}
	
	public static void helper(int[][] inputMatrix, int totalRows , int totalCols , int[] neighbourX, int[] neighbourY , List<String> visitedCells, int curCellX, int curCellY) {
		
		String curCell = curCellX + "," + curCellY;
		
		System.out.println(inputMatrix[curCellX][curCellY]);
		
		visitedCells.add(curCell);
		
		int curNeighbourCellX ;
		int curNeighbourCellY ;
		String curNeighbourCell ;
		
		for(int i = 0 ; i < neighbourX.length ; i++) {
			
			curNeighbourCellX = curCellX + neighbourX[i];
			curNeighbourCellY = curCellY + neighbourY[i];
			curNeighbourCell = curNeighbourCellX + "," + curNeighbourCellY;
			
			if(isValidNeighbour(totalRows, totalCols , curNeighbourCellX, curNeighbourCellY) 
					&& !visitedCells.contains(curNeighbourCell)) {
				
				helper(inputMatrix, totalRows, totalCols, neighbourX, neighbourY, visitedCells, curNeighbourCellX, curNeighbourCellY);
			}
		}
	}

	private static boolean isValidNeighbour(int totalRows, int totalCols, int x, int y) {
		
		boolean result = false;
		
		if(x >= 0 && x < totalRows && y >= 0 && y < totalCols) {
			result = true;
		}
		
		return result;
	}

}
