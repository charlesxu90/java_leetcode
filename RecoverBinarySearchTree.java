/***
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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

// Inorder traversal to find illegal ones, then swap them.
public class Solution {
    // Solution 1: O(n)
    // Using list to record all nodes
    /*
    public void recoverTree(TreeNode root) {
        List<TreeNode> nlist = new ArrayList<TreeNode>();
        inorderTraversal(root, nlist);
        TreeNode a = null, b = null;
        int i = 0, j;
        for (; i < nlist.size() - 1; i++)
            if (nlist.get(i).val > nlist.get(i + 1).val) {
                a = nlist.get(i);
                break;
            }
        for (j = i + 2; j < nlist.size(); j++)
            if (nlist.get(j - 1).val > nlist.get(j).val) {
                b = nlist.get(j);
                break;
            }
        if (b == null)
            b = nlist.get(i + 1);
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    private void inorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        inorderTraversal(root.left, list);
        list.add(root);
        inorderTraversal(root.right, list);
    }
    */

    // Solution 2: O(n), O(1)
    // Based on Morris Inorder Traversal
    public class Pair<F, S> {
        private F first;
        private S second;
    }
    public void recoverTree(TreeNode root) {
        Pair<TreeNode, TreeNode> broken = new Pair<TreeNode, TreeNode>();
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                detect(broken, prev, cur);
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode node = cur.left;
                while(node.right != null && node.right != cur)
                    node = node.right;

                if (node.right == null) { // Construct threading
                    node.right = cur;
                    cur = cur.left;
                } else { // node.right == cur, visit threading
                    /*      3
                     *     /'
                     *    1 '
                     *     \'
                     *      2
                     */
                    detect(broken, prev, cur);
                    node.right = null; // Remove threading
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        int temp = broken.first.val;
        broken.first.val = broken.second.val;
        broken.second.val = temp;
    }
    private void detect(Pair<TreeNode, TreeNode> broken, TreeNode prev, TreeNode cur) {
        if (prev != null && prev.val > cur.val) {
            if (broken.first == null) {
                broken.first = prev;
            }
            broken.second = cur;
        }
    }
}
