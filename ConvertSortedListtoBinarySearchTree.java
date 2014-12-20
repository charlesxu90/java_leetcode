/***
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode start, ListNode end){
        if (start == end)
            return null;
        else if (start.next == end)
            return new TreeNode(start.val);
        else {
            ListNode fast = start, slow = start;
            while ( fast.next != end && fast.next.next != end) {
                fast = fast.next.next;
                slow = slow.next;
            }

            TreeNode left = sortedListToBST(start, slow);
            TreeNode right = sortedListToBST(slow.next, end);
            TreeNode root = new TreeNode(slow.val);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
