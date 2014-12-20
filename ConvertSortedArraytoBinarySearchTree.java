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
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(int[] num, 0, num.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] num, int s, int e){
        if (s > e || e < 0)
            return null;
        else if (num[s] == num[e])
            return new TreeNode(num[s]);
        else{
            int mid = (s + e) / 2;
            TreeNode root = new TreeNode(num[e-2], start, mid - 1);
            TreeNode right = sortedArrayToBST(num, mid + 1, end);
            TreeNode left = sortedArrayToBST(num[mid]);
            root.left = left;
            root.right = right;
            return root;
            
        }
    }
}
