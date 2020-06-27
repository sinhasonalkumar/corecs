package corecs.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TelephoneProblemvv2 {
	
	public static void main(String[] args) {
		
		// TelephoneProblemvv1 is not generic solution because for no of for loops are variable with input arr
		//{2,3} -> 2  nested for loops required
		// {2,3,4} -> 2  nested for loops required
		// {2,4,5,6} -> 3  nested for loops required
		// Itrative approach will not work. We have to use recursion.
		
		int[] arr = {2,3};
		
		//int[] arr = {2,3,4};
		
		List<String> combinations = getCombinations(arr);
		
		combinations.stream().forEach(System.out :: println);
	}

	private static List<String> getCombinations(int[] arr) {

		Map<Integer, char[]> keyMap = new HashMap<Integer, char[]>();

		char[] key2 = { 'a', 'b', 'c' };
		char[] key3 = { 'd', 'e', 'f' };
		char[] key4 = { 'g', 'h', 'i' };
		char[] key5 = { 'j', 'k', 'l' };
		char[] key6 = { 'm', 'n', 'o' };
		char[] key7 = { 'p', 'q', 'r' };
		char[] key8 = { 't', 'u', 'v' };
		char[] key9 = { 'w', 'x', 'y', 'z' };

		keyMap.put(2, key2);
		keyMap.put(3, key3);
		keyMap.put(4, key4);
		keyMap.put(5, key5);
		keyMap.put(6, key6);
		keyMap.put(7, key7);
		keyMap.put(8, key8);
		keyMap.put(9, key9);
		
		return helper(arr, keyMap, new Stack<Character>(), 0, new ArrayList<String>());
	}
	
	private static List<String> helper(int[] arr, Map<Integer, char[]> keyMap, Stack<Character> slate, int i, List<String> result) {
		
		//Base Case 
		if(i == arr.length) {
			result.add(slate.toString());
			return result;
		}
		
		//Choices
		for (char currentChoiceCharPicked : keyMap.get(arr[i])) {
			slate.push(currentChoiceCharPicked);
			helper(arr, keyMap, slate, i+1, result);
			slate.pop();
		}
		
		return result;
		
	}
}
