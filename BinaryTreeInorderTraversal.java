/***
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
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
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    // Solution 1: Recursive O(n) O(1)
    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        inorderTraversal(root, ret);
        return ret;
    }
    private void inorderTraversal(TreeNode node, List<Integer> ret) {
        if (node == null)
            return;
        if (node.left != null)
            inorderTraversal(node.left, ret);
        ret.add(node.val);
        if (node.right != null)
            inorderTraversal(node.right, ret);
    }
    */
    // Solution 2: Iterative O(n), O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while(!stk.isEmpty() || cur != null) {
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            } else {
                cur = stk.pop();
                ret.add(cur.val);
                cur = cur.right;
            }
        }
        return ret;
    }
}
