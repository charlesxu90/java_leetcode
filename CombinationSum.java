/***
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 */
import java.util.ArrayList;

public class Solution {
    // Solution 1: O(n!) O(n)
    /*
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> comb = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, ret, comb, 0);
        return ret;
    }

    private void dfs(int[] candidates, int target, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> path, int k) {
        int sum = 0;
        for (int i : path)
            sum += i;
        if (sum > target)   return;
        else if (sum == target) {
            ArrayList<Integer> newpath = new ArrayList<Integer>(path);
            ret.add(newpath);
            return;
        }
        for (int i = k; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target, ret, path, i);
            path.remove(path.size() - 1);
        }
    }
    */

    // Solution 2: O(n!) O(n)
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> comb = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, ret, comb, 0);
        return ret;
    }

    private void dfs(int[] candidates, int gap, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> path, int k) {
        if (gap == 0) {
            ArrayList<Integer> newpath = new ArrayList<Integer>(path);
            ret.add(newpath);
            return;
        }
        for (int i = k; i < candidates.length; i++) {
            if (gap < candidates[i]) return;

            path.add(candidates[i]);
            dfs(candidates, gap - candidates[i], ret, path, i);
            path.remove(path.size() - 1);
        }
    }
}
