/***
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 *
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 *  ]
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    // Solution 1; Recursive T: O(2^n), S: O(n)
    // Another Recursive methods is to count the occurence of elements, the do the adding based on occurence.
    /*
    public List<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        subsets(num, 0, path, ret);
        return ret;
    }

    private void subsets(int[] num, int idx, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ret) {
        ArrayList<Integer> newpath = new ArrayList<Integer>(path);
        ret.add(newpath);
        for (int i = idx; i < num.length; i++) {
            if (i != idx && num[i] == num[i - 1])
                continue;
            path.add(num[i]);
            subsets(num, i + 1, path, ret);
            path.remove(path.size() - 1);
        }
    }
    */
    // Solution 2; Iterative 
     public List<ArrayList<Integer>> subsetsWithDup(int[] num) {
         Arrays.sort(num);
         List<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
         ret.add(new ArrayList<Integer>());
         int prev_sz = 0;
         for (int i = 0; i < num.length; i++) {
             int size = ret.size();
             for (int j = 0; j < size; j++) {
                 if (i == 0 || num[i] != num[i - 1] || j >= prev_sz) {
                     ArrayList<Integer> path = new ArrayList<Integer>(ret.get(j));
                     path.add(num[i]);
                     ret.add(path);
                 }
             }
             prev_sz = size;
         }
         return ret;
     }

   
}
