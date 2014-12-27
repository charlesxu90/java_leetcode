/***
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
import java.util.ArrayList;
import java.util.HashMap;
public class Solution {
    // Solution 1: Based on nextPermutation, T: O(n!), S:O(1)
    /*
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        do{
            List<Integer> permute = new ArrayList<Integer>();
            for (int i = 0; i < num.length; i++)
                permute.add(num[i]);
            ret.add(permute);
        }while(nextPermutation(num));
        return ret;
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
    // Solution 2: Recursive dfs, T: O(n!), S: O(n) Not implemented
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List><Integer>> ret;
    }
    private void permute() {

    }

    // Solution 3: Recursive swapping ? Not clear
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permuteUnique(num, 0, result);
        return result;
    }

    void permuteUnique(int[] num, int begin,
            ArrayList<ArrayList<Integer>> result) {
        if (begin > num.length - 1) {
            ArrayList<Integer> item = new ArrayList<Integer>();
            for (int h = 0; h < num.length; h++) {
                item.add(num[h]);
            }
            result.add(item);
        }
        for (int end = begin; end < num.length; end++) {
            if (isSwap(num, begin, end)) {
                swap(num, begin, end);
                permuteUnique(num, begin + 1, result);
                swap(num, begin, end);
            }
        }
    }

    boolean isSwap(int[] arr, int i, int j) {
        for (int k = i; k < j; k++) {
            if (arr[k] == arr[j]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
