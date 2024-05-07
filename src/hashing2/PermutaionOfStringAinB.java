/**
 * 
 */
package hashing2;

/**
 * You are given two strings, A and B, of size N and M, respectively.
   You have to find the count of all permutations of A present in B as a substring.
   You can assume a string will have only lower case letters.
 *
 */
public class PermutaionOfStringAinB {

	static int solve(String A, String B) {
		int[] hash_a = new int[26]; //hash map for String A
		int[] hash_b = new int[26]; //hash map for String B
		int m = A.length();
		int n = B.length();
		int ans = 0;
		//count frequency of each character in A & B  for 1st window
		// we are iterating over length of String A, as it's permutation has to be found
		for(int i = 0;i<m;i++) {
			hash_a[A.charAt(i) - 'a']++;
			hash_b[B.charAt(i) - 'a']++;
		}
		boolean flag = true;
		//check for 1st window if it's the permutation or not
		for(int i=0;i<25;i++) {
			if(hash_a[i] == hash_b[i]) {
				continue;
			}else {
				flag = false;
				break;
			}
		}
		if(flag == true) {
			ans++;
		}
		for(int j = 1;j<= n-m;j++) {
			hash_b[B.charAt(j-1) - 'a']--; // moving window
			hash_b[B.charAt(j+m-1)-'a']++;
			flag = true;
			for(int i=0;i<25;i++) {
				if(hash_a[i] == hash_b[i]) {
					continue;
				}else {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				ans++;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String A="abc";
		String B = "abcbacabc";
		System.out.println(solve(A,B));

	}

}
