/***
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return treeBuild(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode treeBuild(int[] inorder, int is, int ie, int[] postorder, int ps, int pe){
        if(is > ie || ps > pe)
            return null;
        int rootVal = postorder[pe];
        TreeNode root = new TreeNode(rootVal);
        for(int i = is; i <= ie; i++){
            if(inorder[i] == rootVal){
                TreeNode left = treeBuild(inorder, is, i-1, postorder, ps, ps+i-1-is);
                TreeNode right = treeBuild(inorder, i+1, ie, postorder, pe-ie+i, pe-1);
                root.left = left;
                root.right = right;
            }
        }
        return root;
    }
}
