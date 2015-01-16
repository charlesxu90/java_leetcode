/***
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 * Consider the following tree:
 *       4
 *     /   \
 *    3     6
 *   / \   / \
 *  1   2 5   7
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
public class BinarySearchTreeIterator {
    private Stack<TreeNode> stk = new Stack<TreeNode>();
    public BinarySearchTreeIterator(TreeNode root) {
        for (; root != null; stk.push(root), root = root.left);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tempNode = stk.pop();
        for(TreeNode node = tempNode.right; node != null; stk.push(node), node = node.left);
        return tempNode.val;
    }

    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n4.left = n3; n4.right = n6;
        n3.left = n1; n3.right = n2;
        n6.left = n5; n6.right = n7;
        BinarySearchTreeIterator i = new BinarySearchTreeIterator(n4);
        int nl[] = new int[7];
        int k = 0;
        while(i.hasNext()) nl[k++] = i.next();
        for (int n: nl)
            System.out.printf("%d\n", n);
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
