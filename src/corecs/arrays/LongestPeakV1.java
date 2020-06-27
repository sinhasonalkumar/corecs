package corecs.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LongestPeakV1 {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
		
		int longestPeak = find(arr);
		
		System.out.println("LongestPeak -> " + longestPeak);
	}
	
	public static int find(int[] arr) {
		
		int result = Integer.MIN_VALUE;
		
		
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		int p1 = 0;
		int p2 = 1;
		
		List<Integer> list = null;
		
		Integer curPeak = null;
		
		while(p2 < arr.length) {
			
			list = new ArrayList<Integer>();
			curPeak = null;
			
			while(p2 < arr.length && arr[p1] <= arr[p2]) {
				if(arr[p1] < arr[p2]) {
					list.add(arr[p1]);
					p1++;
					p2++;	
				}else {
					if(arr[p1] == arr[p2]) {
						list.clear();
						p1++;
						p2++;	
					}
				}
				
			}
			
			if(p2 < arr.length) {
				curPeak = p1;
			}
			
			while(p2 < arr.length && arr[p1] > arr[p2]) {
				list.add(arr[p1]);
				p1++;
				p2++;
			}
			
			list.add(arr[p1]);
			
			if(curPeak != null) {
				map.put(arr[curPeak], list);
			}
		}
	
		Integer resultPeak = null;
		for (Entry<Integer, List<Integer>>  entry : map.entrySet()) {
			
			if(result < entry.getValue().size()) {
				result = entry.getValue().size();
				resultPeak = entry.getKey();
			}
		}
		
		System.out.println("LongestPeak Sequence -> " + map.get(resultPeak) + " -> Peak -> " + resultPeak);
		
		return result;
	}

}
