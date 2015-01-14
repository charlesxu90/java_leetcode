/***
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * For example,
 *
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = 12 + 13 = 25.
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
public class Solution {
    public int sumNumbers(TreeNode root) {
        int sum[] = new int sum[1];
        int path = 0;
        dfs(sum, root, path);
        return sum[0];
    }
    private void dfs(int[] sum, TreeNode root, int path) {
        if (root == null)
            return;
        path = path * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum[0] += path;
            return;
        }
        dfs(sum, root.left, path);
        dfs(sum, root.right, path);
    }
}
