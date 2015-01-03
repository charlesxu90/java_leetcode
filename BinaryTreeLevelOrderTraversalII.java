/***
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *  /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
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
    // Solution 1: T/S: O(n) 
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        traverse(root, 1, ret);
        for (int i = 0; i < ret.size() - 1; i++) {
            ret.add(i, ret.remove(ret.size() - 1));
        }
        return ret;
    }
    private void traverse( TreeNode root, int level, ArrayList<ArrayList<Integer>> ret) {
        if (root == null) return;
        if (level > ret.size())
            ret.add(new ArrayList<Integer>());
        ret.get(level - 1).add(root.val);
        traverse(root.left, level + 1, ret);
        traverse(root.right, level + 1, ret);
    }
    // Solution 2: iterative T: O(n), S: O(1)
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) return ret;
        Queue<TreeNode> cur = new Queue<TreeNode>();
        Queue<TreeNode> next;
        ArrayList<Integer> level;

        cur.add(root);
        while(!cur.isEmpty()) {
            next = new Queue<TreeNode>();
            level = new ArrayList<Integer>();
            while(!cur.isEmpty()) {
                TreeNode node = cur.get(0);
                cur.remove(0);
                level.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }

            ret.add(0, level);
            cur = next;
        }
        return ret;
    }
}
