/***
 * Given preorder and inorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        return treeBuild(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode treeBuild(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe || is > ie)
            return null;
        int val = preorder[ps];
        TreeNode root = new TreeNode(val);
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == val) {
                root.left = treeBuild(preorder, ps + 1, ps + i - is, inorder, is, i - 1);
                root.right = treeBuild(preorder, pe - ie + i + 1, pe, inorder, i + 1, ie);
            }
        }
        return root;
    }
}
