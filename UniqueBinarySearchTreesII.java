/***
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> subtree = new ArrayList<TreeNode>();
        if (start > end) {
            subtree.add(null);
            return subtree;
        }
        for (int k = start; k <= end; k++) {
            List<TreeNode> leftSubs = generate(start, k - 1);
            List<TreeNode> rightSubs = generate(k + 1, end);
            for (TreeNode i : leftSubs)
                for (TreeNode j: rightSubs) {
                    TreeNode node = new TreeNode(k);
                    node.left = i;
                    node.right = j;
                    subtree.add(node);
                }
        }
        return subtree;
    }
}
