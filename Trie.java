//Trie data structure implementation

import java.util.*;

public class Trie {
	
	class Node{
		char value;
		Node[] children;
		boolean endOfWord;
		
		Node(char l){
			value = l;
			children = new Node[alphabet.length()];
			endOfWord = false;
		}
		
		public void printStrings(String prefix) {
			boolean end = true;
			prefix += Character.toString(value);
			for(Node n : children) {
				if(n != null) {
					n.printStrings(prefix);
					end = false;
				}
			}
			if(end) {
				System.out.println(prefix);
			}
		}
	}
	
	String alphabet;
	Map<Character, Integer> index;	//Mapping of the character of the alphabet to the corresponding indexes
	Node[] root;
	
	public Trie() {
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		index = new HashMap<Character, Integer>();
		for(int i = 0; i < alphabet.length(); i++) {
			index.put(alphabet.charAt(i), i);
		}
		root = new Node[26];
	}
	
	public Trie(String alphabet) {
		this.alphabet = alphabet;
		index = new HashMap<Character, Integer>();
		for(int i = 0; i < alphabet.length(); i++) {
			index.put(alphabet.charAt(i), i);
		}
		root = new Node[alphabet.length()];
	}
	
	public void insert(String s) {
		int l = s.length();
		if(l == 0) {
			return;
		}
		int i = index.get(s.charAt(0));
		if(root[i] == null) {
			root[i] = new Node(s.charAt(0));
		}
		Node current = root[i];
		for(int j = 1; j < l; j++) {
			i = index.get(s.charAt(j));
			if(current.children[i] == null) {
				current.children[i] = new Node(s.charAt(j));
				current = current.children[i];
			}else {
				current = current.children[i];
			}
		}
		current.endOfWord = true;
	}
	
	public boolean contains(String s) {
		int l = s.length();
		if(s.length() == 0) {
			return true;
		}else {
			int i = index.get(s.charAt(0));
			if(root[i] == null) {
				return false;
			}else {
				Node current = root[i];
				for(int j = 1; j < l; j++) {
					i = index.get(s.charAt(j));
					if(current.children[i] == null) {
						return false;
					}else {
						current = current.children[i];
					}
				}
				if(current.endOfWord) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void printStrings() {
		for(Node c : root) {
			if(c != null) {
				c.printStrings("");
			}
		}
	}
}
