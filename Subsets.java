/***
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 *
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Subsets {

    // Solution 1: Recursive Depth search. T: O(2^n), S; O(n)
    // similarly can use a index array instead of path to record sets.
    /*
    public List<ArrayList<Integer>> subsets(int[] S) {
        // Enumeration
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        Arrays.sort(S);
        subsets(S, path, 0, ret);
        return ret;
    }

    private void subsets(int[] S, ArrayList<Integer> path, int step, ArrayList<ArrayList<Integer>> ret){
        if (step == S.length){
            ArrayList<Integer> newpath = new ArrayList<Integer>(path);
            ret.add(newpath);
            return;
        }

        // Do not select
        subsets(S, path, step + 1, ret);

        // select
        path.add(S[step]);
        subsets(S, path, step + 1, ret);
        path.remove(path.size() - 1);
    }
    */

    // Solution 2: Iterative Array Element Addition. T: O(2^n), S: O(1)
    public List<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(new ArrayList<Integer>());
        for ( int i = 0; i < S.length; i++ ) {
            int size = ret.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> subset = new ArrayList<Integer>(ret.get(j));
                subset.add(S[i]);
                ret.add(subset);
            }
        }
        return ret;
    }

    public static void main (String args[]) {
        Subsets sst = new Subsets();
        int[] arr = new int[] {1, 2, 3};

        List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result = sst.subsets(arr);
        System.out.println("Final result:");
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> list = result.get(i);
            System.out.printf("%d th:\t", i);
            for (int j = 0; j < list.size(); j++){
                System.out.printf("%d\t", list.get(j));
            }
            System.out.println();
        }
    }
}
