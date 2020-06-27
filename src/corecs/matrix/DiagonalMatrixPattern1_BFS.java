package corecs.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 {
 	{ 1, 2, 3 },
 	{ 4, 5, 6 },
 	{ 7, 8, 9 }
 }
 
 Explanation:
	https://leetcode.com/problems/diagonal-traverse/
	https://www.geeksforgeeks.org/print-matrix-diagonal-pattern/

Output:  [1,2,4,7,5,3,6,8,9]
 
 */
public class DiagonalMatrixPattern1_BFS {

	public static void main(String[] args) {

		int[][] inputMatrix = buildMatrix();

		print(inputMatrix);
	}

	public static int[][] buildMatrix() {

		int[][] matrix = {
			 				{ 1, 2, 3 },
			 				{ 4, 5, 6 },
			 				{ 7, 8, 9 }
			 			 };
		return matrix;
	}

	public static void print(int[][] inputMatrix) {
		
		Queue<String> queue = new LinkedList<String>();
		
		List<String> visitiedNeighbours = new ArrayList<String>();
		
		int totalRows = inputMatrix.length;
		int totalCols = inputMatrix[0].length;
		
		int curCellX = 0;
		int curCellY = 0;
		String curCell = curCellX + "," + curCellY;
		String[] cellXY;
		
		//NighbourDirection W,N,E,S
		int[] neighbourXCordinates = {0,-1,0,1};
		int[] neighbourYCordinates = {-1,0,1,0};
		
		queue.add(curCell);
		visitiedNeighbours.add(curCell);
		
		int curNeighbourX = curCellX;
		int curNeighbourY = curCellY;
		String curNeighbourCell = curCell;
		
		while(!queue.isEmpty()) {
			
			curCell = queue.poll();
			
			cellXY = curCell.split(",");
			curCellX = Integer.valueOf(cellXY[0]);
			curCellY = Integer.valueOf(cellXY[1]);
			
			System.out.println(inputMatrix[curCellX][curCellY]);
			
			
			for(int i = 0 ; i < neighbourXCordinates.length ; i++) {
				
				curNeighbourX = curCellX + neighbourXCordinates[i];
				curNeighbourY = curCellY + neighbourYCordinates[i];
				curNeighbourCell = curNeighbourX + "," + curNeighbourY;
				
				if(isValidNeighbour(totalRows, totalCols, curNeighbourX, curNeighbourY) 
						&& !visitiedNeighbours.contains(curNeighbourCell)) {
					
					queue.add(curNeighbourCell);
					visitiedNeighbours.add(curNeighbourCell);
				}
			}
			
		}
		
	}

	public static boolean isValidNeighbour(int totalRows, int totalCols, int curRow, int curCol) {
		
		boolean result = false;
		
		if(curRow >= 0 &&  curRow < totalRows && curCol >= 0 && curCol < totalCols) {
			result = true;
		}
		
		return result;
	}
	
	
}
