package corecs.sorting.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


/*
 
 Given a list of points on the 2-D plane and an integer K. 
 The task is to find K closest points to the origin and print them.

	Note: The distance between two points on a plane is the Euclidean distance.
	
	Input : point = [[3, 3], [5, -1], [-2, 4]], K = 2
	Output : [[3, 3], [-2, 4]]
	Square of Distance of origin from this point is 
	(3, 3) = 18
	(5, -1) = 26
	(-2, 4) = 20
   
   So the closest two points are [3, 3], [-2, 4].

	Input : point = [[1, 3], [-2, 2]], K  = 1
	Output : [[-2, 2]]
	Square of Distance of origin from this point is
	(1, 3) = 10
	(-2, 2) = 8 
  
  So the closest point to origin is (-2, 2)
  
 */

public class ClosestPointsToOrigin {
	
	
	public static void main(String[] args) {
		
		//int[][] planeMatrix = { { 3, 3 }, { 5, -1 }, { -2, 4 } };

		//int k = 2;
		
		int[][] planeMatrix = { { 1, 3 }, { -2, 2 } };

		int k = 1;

		
		int[][] closesKPointToOrigin = closesKPointToOrigin(planeMatrix, k);
		
		for(int i=0; i< closesKPointToOrigin.length;i++) {
			System.out.println("(x,y) -> (" + closesKPointToOrigin[i][0] + "," + closesKPointToOrigin[i][1] + ")");
		}
		
	}
	
	public static int[][] closesKPointToOrigin(int[][] planeMatrix, int k) {
		
		int[][] result = new int[k][2];
		
		//Origin (x1,y1) = (0,0)
		
		// Squared Distace to List of points at equal distance 
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		
		List<Integer> indexList;
		
		int curX;
		int curY;
		
		Double curDistnaceFromOrigin; 
		
		for(int i = 0 ; i < planeMatrix.length; i++) {
			
			curX = planeMatrix[i][0];
			curY = planeMatrix[i][1];
			
			curDistnaceFromOrigin = Math.pow(curX, 2) + Math.pow(curY, 2);
			
			if(map.containsKey(curDistnaceFromOrigin.intValue())) {
				map.get(curDistnaceFromOrigin.intValue()).add(i);
			}else {
				indexList = new ArrayList<Integer>();
				indexList.add(i);
				map.put(curDistnaceFromOrigin.intValue(),indexList);
			}
			
		}
		
		int i =0;
		
		for(Entry<Integer, List<Integer>> curEntry : map.entrySet()) {
			
			for(Integer curIndex :  curEntry.getValue()) {
				
				result[i][0] = planeMatrix[curIndex][0];
				result[i][1] = planeMatrix[curIndex][1];
				
				if(i == k-1) {
					return result;
				}
				i++;
			}
		}
		
		return result;
	}

}
