/***
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 * Return
 *
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
import java.util.ArrayList;

public class Solution {
    // Solution 1: T: O(n^2), S: O(n)
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0)
            return ret;
        ArrayList<Integer> level = new ArrayList<Integer>();
        level.add(1);
        while (numRows-- != 0) {
            ArrayList<Integer> newlevel = new ArrayList<Integer>(level);
            ret.add(newlevel);
            level = generateNext(level);
        }
        return ret;
    }

    private ArrayList<Integer> generateNext(ArrayList<Integer> level) {
        ArrayList<Integer> newlevel = new ArrayList<Integer>();
        newlevel.add(1);
        for (int i = 0; i < level.size() - 1; i++){
            newlevel.add(level.get(i) + level.get(i + 1));
        }
        newlevel.add(1);
        return newlevel;
    }
}
