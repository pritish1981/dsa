/**
 * 
 */
package tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Pritish
 *
 */
public class AutoComplete {

	public static class pair implements Comparable < pair > {
	    int first;
	    int second;
	    public pair(int a, int b) {
	        this.first = a;
	        this.second = b;
	    }
	    @Override
	    public int compareTo(pair a) {
	        return this.first - a.first;
	    }
	}
	    
	public static class TrieNode {
		TrieNode[] child;
		ArrayList<pair> res;
		boolean eow;

		public TrieNode() {
			child = new TrieNode[26];
			for (int i = 0; i < 26; i++)
				child[i] = null;
			res = new ArrayList<pair>();
			eow = false;
		}
	}
	
	public static void insert(TrieNode root, String word, int idx, int[] W) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
            if (node.res.size() < 5) {
                node.res.add(new pair(W[idx], idx));
            }
        }
        node.eow = true;
    }
	
	public static ArrayList<pair> query(TrieNode root, String prefix, int[] W) {
		TrieNode node = root;
		ArrayList<pair> ans = new ArrayList<pair>();
		for (int i = 0; i < prefix.length(); i++) {
			int index = prefix.charAt(i) - 'a';
			if (node.child[index] == null) {
				node = node.child[index];
				break;
			}
			node = node.child[index];
		}
		if (node == null) {
			return ans;
		}
		return node.res;
	}
	
	public static void solve(String[] A, int[] W, String[] B) {
		TrieNode root = new TrieNode();
		ArrayList<pair> v = new ArrayList<pair>();
		for (int i = 0; i < A.length; i++) {
			v.add(new pair(W[i], i));
		}
		Collections.sort(v);
		for (int i = v.size() - 1; i >= 0; i--) {
			insert(root, A[v.get(i).second], v.get(i).second, W);
		}
		for (int i = 0; i < B.length; i++) {
			ArrayList<pair> ans = new ArrayList<pair>(query(root, B[i], W));
			if (ans.size() == 0) {
				System.out.println(-1 + " ");
			} else {
				for (int j = 0; j < ans.size(); j++) {
					System.out.print(A[ans.get(j).second] + " ");
				}
				System.out.println();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int t = inp.nextInt();
		inp.nextLine();
		while (t --> 0) {
			int n, m;
			n = inp.nextInt();
			m = inp.nextInt();
			inp.nextLine();
			String s[] = inp.nextLine().split(" ");
			String temp[] = inp.nextLine().split(" ");
			int[] wt = new int[n];
			for (int i = 0; i < temp.length; i++)
				wt[i] = Integer.parseInt(temp[i]);
			String q[] = inp.nextLine().split(" ");
			solve(s, wt, q);
		}
		inp.close();

	}

}
