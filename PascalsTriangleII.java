/***
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class Solution {
    // Solution 1; T: O(n^2), S: O(n). time limit exceed 
    /*
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        List<Integer> newlist;
        ret.add(1);
        while (--rowIndex != 0){
            newlist = new ArrayList<Integer>();
            newlist.add(1);
            for (int i = 0; i < ret.size() - 1; i++){
                newlist.add(ret.get(i) + ret.get(i + 1));
            }
            newlist.add(1);
            ret = newlist;
        }
        return ret;
    }
    */
    // Solution 2. T O(n^2), S O(n) 
    // updates from end to start, so previous values can be reused.
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                ret.add(j, ret.get(j - 1) + ret.get(j));
                ret.remove(j + 1);
            }
            ret.add(1);
        }
        return ret;
    }

}
