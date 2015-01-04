/***
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 *     A solution set is:
 *         (-1,  0, 0, 1)
 *         (-2, -1, 1, 2)
 *         (-2,  0, 0, 2)
 */
import java.util.ArrayList;

public class Solution {
    // Solution 1. Use the same strategy as 3 Sum. O(n^3) time exceeded

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        int n = num.length;
        if (n < 4) return ret;
        Arrays.sort(num);
        int i, j, k, p;
        int sum;
        for (i = 0; i <= n - 4; i++) {
            if (i > 0 && num[i] == num[i - 1])  continue;
            for (j = i + 1; j <= n - 3; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) continue;
                k = j + 1;
                p = n - 1;
                while ( k < p) {
                    sum = num[i] + num[j] + num[k] + num[p];
                    if (sum > target) {
                        do { p--;
                        } while (k < p && num[p] == num[p + 1]);
                    } else if(sum < target) {
                        do { k++;
                        } while (k < p && num[k] == num[k - 1]);
                    } else {
                        ArrayList<Integer> soluset = new ArrayList<Integer>();
                        soluset.add(num[i]);
                        soluset.add(num[j]);
                        soluset.add(num[k]);
                        soluset.add(num[p]);
                        ret.add(soluset);
                        p--;
                        do { k++;
                        } while (k < p && num[k] == num[k - 1]);
                    }
                }
            }
        }
        return ret;
    }
    // Solution 2. T; Mean O(n^2), Worst O(n^4), S: O(n^2)
    // Using hashmap to store sum of two numbers

    // Solution 3. T: O(n^2) S: O(n^2)

}
