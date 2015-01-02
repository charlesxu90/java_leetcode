/***
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        findPath(path, ret, root, sum);
        return ret;
    }

    private void findPath(ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ret, TreeNode root, int sum) {
        if (root == null) 
            return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
            ArrayList<Integer> newpath = new ArrayList<Integer>(path);
            newpath.add(root.val);
            ret.add(newpath);
            return;
            } else
                return;
        }
        path.add(root.val);
        findPath(path, ret, root.left, sum - root.val);
        findPath(path, ret, root.right, sum - root.val);
        path.remove(path.size() - 1);
    }
}
