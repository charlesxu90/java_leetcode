/***
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *  /  \
 * 15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) return ret;
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        cur.add(root);
        while (!cur.isEmpty()) {
            TreeNode n1 = cur.get(0);
            cur.remove(0);
            level.add(n1.val);
            if (n1.left != null)
                next.add(n1.left);
            if (n1.right != null)
                next.add(n1.right);
            if(cur.isEmpty()) {
                cur = next;
                ret.add(level);
                level = new ArrayList<Integer>();
                next = new ArrayList<TreeNode>();
            }
        }
        return ret;
    }
}
