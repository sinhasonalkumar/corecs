package corecs.arrays.search.trie.prefixtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 Implement autocomplete using trie. 
 When searching “amaz”, it should return words that start with “amaz” such as “amazon”, “amazon prime”, “amazing” etc. 
 */


public class AutoCompleteStartsWith {

	public static void main(String[] args) {
		
		String searchText = "amaz";
		
		Trie trie = new Trie(); 
		
		trie.add("amazon"); 
		trie.add("amazonprime"); 
		trie.add("amazing"); 			 
		trie.add("amazingspiderman"); 
		trie.add("amazed");
		trie.add("alibaba");
		trie.add("aliexpress");
		trie.add("ebay");
		trie.add("walmart");
		
		List<String> searchAutoComplete = trie.searchAutoComplete(searchText);
		
		searchAutoComplete.forEach(System.out :: println);
		
	}
	
	
}

class Trie{
	
	private TrieNode root; 
	
	public Trie() {
		this.root = new TrieNode();
	}
	
	public void add(String word) {
		addHelper(word, 0, this.root);
	}
	
	public void addHelper(String word, int start, TrieNode curNode) {
		
		if(start == word.length()) {
			curNode.isEndOfWord = (start == word.length());
			return;
		}
		
		int curIndex = word.charAt(start) - 'a';
		
		if(curNode.children[curIndex] == null) {
			curNode.children[curIndex]  = new TrieNode();
		}
		
		curNode = curNode.children[curIndex];
		addHelper(word, start+1, curNode);
	}
	
	public List<String> searchAutoComplete(String word) {
		
		TrieNode foundTrieNode = searchHelper(this.root, word, 0);
		
		List<String> allWordsStartWith = new ArrayList<String>();
		
		Stack<Character> slate = new Stack<Character>();
		
		for(int i=0; i< word.length();i++) {
			slate.push(word.charAt(i));
		}
		
		dfs(foundTrieNode, slate, allWordsStartWith);

		return allWordsStartWith;

	}
	
	private TrieNode searchHelper(TrieNode curTrieNode, String word, int start) {
		
		if(start == word.length()) {
			return curTrieNode;
		}
		
		int curIndex = word.charAt(start) - 'a';
		
		if(curTrieNode.children[curIndex] != null) {
			curTrieNode = curTrieNode.children[curIndex];
			return searchHelper(curTrieNode, word, start+1);
		}else {
			return null;
		}
	}
	
	private void dfs(TrieNode curTrieNode, Stack<Character> slate, List<String> result) {
		
		if(curTrieNode == null) {
			return;
		}
		
		if(curTrieNode.isEndOfWord) {
			result.add(charStackToString(slate));
		}
		
		char curChar;
		
		for(int i=0 ; i< curTrieNode.children.length; i++) {
			
			if(curTrieNode.children[i] != null) {
				curChar = (char)(i+ 'a');
				slate.push(curChar);
				dfs(curTrieNode.children[i],slate, result);
				slate.pop();
			}
			
		}
		
	}
	
	public String charStackToString(Stack<Character> stack) {
		
		StringBuffer s = new StringBuffer();
		
		for (Character character : stack) {
			s.append(character);
		}
		
		return s.toString();
	}
}

class TrieNode{
	
	private static final int NO_OF_ALBHABET = 26;
	
    TrieNode[] children;
	
    boolean isEndOfWord;
	
	public TrieNode() {
	
		this.children = new TrieNode[NO_OF_ALBHABET];
		
		for (TrieNode curTriNode : children) {
			curTriNode = null;
		}
		this.isEndOfWord = false;
	}
}
