/**
 * 
 */
package dp.three;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given the weights and profits of N items, in the form of {profit, weight} put these items in a knapsack 
 * of capacity W to get the maximum total profit in the knapsack.
 * 
 * /**
	 * Approach:
	 * 1.Calculate the ratio (profit/weight) for each item.
       2.Sort all the items in decreasing order of the ratio.
       3.Initialize res = 0, curr_cap = given_cap.
       4.Do the following for every item i in the sorted order:
         a.If the weight of the current item is less than or equal to the remaining capacity then add the value of that item into the result
         b.Else add the current item as much as we can and break out of the loop.
       5.Return res.
	 */

public class FractionalKnapsack {

	static class ItemValue {

		int profit, weight;

		// Item value function
		public ItemValue(int profit, int weight) {
			this.weight = weight;
			this.profit = profit;
		}
	}

	public static double getMaxValue(ItemValue[] arr, int capacity) {
		// Sorting items by profit/weight ratio;
		Arrays.sort(arr, new Comparator<ItemValue>() {
			@Override
			public int compare(ItemValue item1, ItemValue item2) {
				double cpr1 = new Double((double) item1.profit / (double) item1.weight);
				double cpr2 = new Double((double) item2.profit / (double) item2.weight);
				if (cpr1 < cpr2)
					return 1;
				else
					return -1;
			}
		});

		double ans = 0d;
		for (ItemValue i : arr) {
			int curWt = (int) i.weight;
			int curprofit = (int) i.profit;
			if (curWt <= capacity) {
				ans += curprofit;
				// this weight can be picked as whole
				capacity -= curWt;
				
			} else {
				// item can't be picked as whole
				double fraction = ((double) curprofit / (double) curWt);
				ans += (int)fraction * capacity;
				break;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		ItemValue[] arr = { new ItemValue(60, 10), new ItemValue(100, 20), new ItemValue(120, 30) };

		int capacity = 50;

		double maxValue = getMaxValue(arr, capacity);
		System.out.println("Maximum total profit in knapsack :: " + maxValue);

	}
	//Time Complexity: O(N * logN), Auxiliary Space: O(N)

}
