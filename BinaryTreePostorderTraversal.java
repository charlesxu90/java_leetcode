/***
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
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
    // Solution 1: Recursive O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        dfs(ret, root);
        return ret;
    }

    private void dfs(List<Integer> ret, TreeNode root) {
        if (root == null)
            return;
        dfs(ret, root.left);
        dfs(ret, root.right);
        ret.add(root.val);
    }

    // Solution 2: Iterative O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        TreeNode n = root, p;
        Stack<TreeNode> stk = new Stack<TreeNode>();

        do{
            while (n != null) {
                stk.push(n);
                n = n.left;
            }
            p = null;
            while (!stk.isEmpty()) {
                n = stk.pop();
                if (n.right == p) {
                    ret.add(n.val);
                    p = n;
                } else {
                    stk.push(n);
                    n = n.right;
                    break;
                }
            }
        }while(!stk.isEmpty());
        return ret;
    }
}
