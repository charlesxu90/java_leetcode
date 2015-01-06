/***
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 */
import java.util.ArrayList;

public class Solution {
    // O(n!) O(n)
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
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
        for (int i = k, c = 0; i < candidates.length; i++, c++) {
            if (gap < candidates[i]) return;
            if (i > 0 && c > 0 && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            dfs(candidates, gap - candidates[i], ret, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
