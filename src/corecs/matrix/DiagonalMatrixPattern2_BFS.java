package corecs.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Matrix =>       1     2     3     4
                5     6     7     8
                9     10    11   12
                13    14    15   16
                17    18    19   20 
  
Observe the sequence
         1 /  2 /  3 /  4
          / 5  /  6 /  7 /  8
              /  9 / 10 / 11 / 12
                  / 13 / 14 / 15 / 16
                      / 17 / 18 / 19 / 20 
  
    1
	5 2
	9 6 3
	13 10 7 4
	17 14 11 8
	18 15 12
	19 16
	20 
	
	1 5 2 9 6 3 13 10 7 4 17 14 11 8 18 15 12 19 16 20
	
*/

public class DiagonalMatrixPattern2_BFS {

	public static void main(String[] args) {

		int[][] inputMatrix = buildMatrix();

		print(inputMatrix);
	}

	public static int[][] buildMatrix() {

		int[][] matrix = {
			 				{ 1, 2,  3,  4 },
			 				{ 5, 6,  7,  8 },
			 				{ 9, 10, 11, 12},
			 				{ 13,14, 15, 16},
			 				{ 17,18, 19, 20}
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
		
		//NighbourDirection N,S,E,W
		int[] neighbourXCordinates = {-1,1,0,0};
		int[] neighbourYCordinates = { 0,0,1,-1};
		
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
