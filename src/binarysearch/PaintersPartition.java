/**
 * 
 */
package binarysearch;

/**
 * In Painters Partition problem, we have M boards of length {l1, l2,... lm} to paint, and there are N painters available. 
 * In Painters Partition, each painter takes one unit of time to paint one unit of the board.
   Calculate the minimum amount of time to complete this task while keeping in mind that any painter will only paint contiguous sections of the board.
   The board cannot be painted partially by one painter and partially by another, which means they cannot share the board to paint. 
   Every painter will paint the contiguous board, which means that if the painter paints boards 1 and 3 but not 2, the painting is invalid.
   
   https://www.youtube.com/watch?v=6A8Oa0XpEwE
 *
 */
public class PaintersPartition {

	static boolean isPossibleSol(int[] ar, int a, int m) {
		//a = no of painter, m = mid value
		int painters = 1;
		int pbc = 0;//painter board count
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] > m) {
				return false;
			}
			if (pbc + ar[i] <= m) {
				pbc = pbc + ar[i];
			} else {
				painters++;
				if (painters > a) {
					return false;
				}
				pbc = ar[i];
			}
		}
		return true;
	}
	
	static int maxTime(int[] ar, int a, int b) {
		int l = 0, h= 0;
		for(int i=0;i<ar.length;i++) {
			h = h + ar[i];
		}
		int res = -1;
		while(l <= h) {
			int m = (l+h)/2;
			if(isPossibleSol(ar, a, m) == true) {
				res = m;
				h = m -1;
			}else {
				l = m +1;
			}
		}
		
		return res * b;
	}

	public static void main(String args[]) {
		int arr[] = {10,20,30,40 };
		int a = 2;
		int b = 2;
		System.out.println(maxTime(arr, a, b));
	}

}
