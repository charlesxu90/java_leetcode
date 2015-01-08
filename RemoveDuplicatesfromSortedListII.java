/***
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
*/
public class Solution {
    // Solution 1. Iterative: O(n), O(1)
    /*
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode ret = new ListNode(Integer.MIN_VALUE);
        ret.next = head;
        ListNode cur = ret.next;
        ListNode prev = ret;
        while(cur != null) {
            boolean duplicated = false;
            while(cur.next != null && cur.val == cur.next.val) {
                duplicated = true;
                cur = cur.next;
            }
            if (duplicated) { // Delete last duplicated node
                cur = cur.next;
                continue;
            }
            prev.next = cur;
            prev = prev.next;
            cur = cur.next;
        }
        prev.next = cur;
        return ret.next;
    }
    */

    // Solution 2. Recursive: O(n), O(1)
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head.next;
        if (head.val == p.val) {
            while(p != null && head.val == p.val)
                p = p.next;
            return deleteDuplicates(p);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    } 
}
