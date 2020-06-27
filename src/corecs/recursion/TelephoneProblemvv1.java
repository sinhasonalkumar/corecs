package corecs.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneProblemvv1 {

	public static void main(String[] args) {

		int[] arr = { 5, 3 };

		List<String> keyCombinations = getCombinations(arr);
		keyCombinations.stream().forEach(System.out::println);

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

		char[] arr1 = keyMap.get(arr[0]);
		char[] arr2 = keyMap.get(arr[1]);

		List<String> result = new ArrayList<String>();

		for (char c1 : arr1) {

			for (char c2 : arr2) {
				result.add(Character.toString(c1) + Character.toString(c2));
			}

		}

		return result;
	}

}
