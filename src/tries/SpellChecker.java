/**
 * 
 */
package tries;

import java.util.Arrays;

/**
 * @author Pritish
 *
 */
public class SpellChecker {

	static TrieNode root;

	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean eow;

		TrieNode() {
			eow = false;
			for (int i = 0; i < 26; i++) {
				children[i] = null;
			}
		}
	}

	static void insert(String word) {
		int index;
		int i;
		TrieNode node = root;
		for (i = 0; i < word.length(); i++) {
			index = word.charAt(i) - 'a';
			if (node.children[index] == null) {
				node.children[index] = new TrieNode();
			}
			node = node.children[index];
		}
		node.eow = true;
	}

	static boolean search(String word) {
		int index, i;
		TrieNode node = root;
		for (i = 0; i < word.length(); i++) {
			index = word.charAt(i) - 'a';
			if (node.children[index] == null) {
				return false;
			}
			node = node.children[index];
		}
		return (node != null && node.eow);
	}

	static int[] solve(String[] A, String[] B) {
		root = new TrieNode();
		for (String temp : A)
			insert(temp);
		int[] ans = new int[B.length];
		for (int i = 0; i < B.length; i++) {
			if (search(B[i]) == true) {
				ans[i] = 1;
			} else {
				ans[i] = 0;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String[] A = { "hat", "cat", "rat" };
		String[] B = { "cat", "ball" };
		System.out.println(Arrays.toString(solve(A, B)));
	}

}
