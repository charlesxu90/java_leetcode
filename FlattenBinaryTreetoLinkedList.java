/***
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
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
import java.util.Stack;
public class Solution {
    // Solution 1: O(n) O(logn n)
    public void flatten(TreeNode root) {
       flatten(root, null); 
    }
    private TreeNode flatten(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        root.right = flatten(root.left, flatten(root.right, tail));
        root.left = null;
        return root;
    }

    // Solution 2: O(n) O(log n)
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);

        if (root.left == null) return;

        TreeNode p = root.left;
        while(p.right != null) p = p.right;
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }

    // Solution 3: O(n) O(log n);
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode p = stk.pop();
            if (p.right != null)
                stk.push(p.right);
            if (p.left != null)
                stk.push(p.left);
            p.left = null;
            if (!stk.isEmpty())
                p.right = stk.peek();
        }
    }
}
