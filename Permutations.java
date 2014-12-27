/***
 * Given a collection of numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
import java.util.List;
import java.util.ArrayList;

public class Solution {
    // Solution 1: Based on next permutations, T: O(n!), S: O(1)
    /*
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        do{
            List<Integer> permute = new ArrayList<Integer>();
            for (int i = 0; i < num.length; i++)
                permute.add(num[i]);
            ret.add(permute);
        }while(nextPermutation(num));
    }
    private boolean nextPermutation(int[] num) {
        int i1 = -1;
        int i2 = -1;
        int i = num.length - 1;
        while(i > 0 && num[i - 1] >= num[i])
            i--;
        if (i == 0 ) {
            Arrays.sort(num);
            return false;
        }

        i1 = i - 1;
        int j = i1 + 1;
        while(j < num.length && num[j] > num[i1])
            j++;
        i2 = j - 1;
        int temp = num[i1];
        num[i1] = num[i2];
        num[i2] = temp;
        Arrays.sort(num, i1 + 1, num.length);
        return true;
    }
    */
    // Solution 2: Recursive, depth search, T: O(n!), S: O(n)
    public List<ArrayList<Integer>> permute(int[] num) {
        Arrays.sort(num);

        List<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        dfs(num, path, ret);
        return ret;
    }

    private void dfs(int[] num, ArrayList<Integer> path, List<ArrayList<Integer>> ret) {
        if (path.size() == num.length) {
            ArrayList<Integer> newpath = new ArrayList<Integer>(path);
            ret.add(newpath);
            return;
        }

        for (int i = 0; i < num.length; i++) {
            int pos = path.indexOf(num[i]);

            if (pos == -1) {
                path.add(num[i]);
                dfs(num, path, ret);
                path.remove(path.size() - 1);
            }
        }
    }

}
