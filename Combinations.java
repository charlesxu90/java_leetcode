/***
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
import java.util.List;
import java.util.ArrayList;

public class Combinations {
    
    // Solution 1: Recursive, T: O(n!), S: O(n)
    /*
    public List<ArrayList<Integer>> combine(int n, int k) {
        List<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        combine(1, n, k, path, ret);
        return ret;
    }

    private void combine(int m, int n, int k, ArrayList<Integer> path, List<ArrayList<Integer>> ret) {
       if (path.size() == k) {
            ArrayList<Integer> newpath = new ArrayList<Integer>(path);
            ret.add(newpath);
            return;
        }
        for (int i = m; i <= n; i++) {
            path.add(i);
            combine(i + 1, n, k, path, ret);
            path.remove(path.size() - 1);
        }
    }
    */

    // Solution 2: Iterative
    // Use prev permutation
    // Too complext, ignore

    public static void main (String args[]) {
        Combinations comb = new Combinations();
        List<ArrayList<Integer>> ret = comb.combine(4, 2);

        for (int i = 0; i < ret.size(); i++) {
            List<Integer> result = ret.get(i);
            System.out.printf("\nResult %d: ", i + 1);
            for (int j= 0; j < result.size(); j++ ) {
                System.out.printf("%d, ", result.get(j));
            }
            System.out.println();
        }
    }
}
