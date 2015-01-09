/***
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
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
    // Solution 1: O(n), O(1)
    /*
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode head1 = null, head2 = null;
        ListNode cur = head;
        ListNode cur1 = null, cur2 = null;
        while (cur != null) {
            if (cur.val < x) {
                if (head1 == null) {
                    head1 = cur;
                    cur1 = head1;
                    cur = cur.next;
                } else {
                    cur1.next = cur;
                    cur = cur.next;
                    cur1 = cur1.next;
                }
            } else {
                if (head2 == null) {
                    head2 = cur;
                    cur = cur.next;
                    cur2 = head2;
                } else {
                    cur2.next = cur;
                    cur = cur.next;
                    cur2 = cur2.next;
                }
            }
        }
        if (head1 == null)  return head2;
        if (head2 == null)  return head1;
        cur1.next = head2;
        cur2.next = null;
        return head1;
    }
    */

    // Solution 2: O(n), O(1)
    //
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode head_left = new ListNode(1);
        ListNode head_right = new ListNode(1);

        ListNode cur_left = head_left;
        ListNode cur_right = head_right;

        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val < x) {
                cur_left.next = cur;
                cur_left = cur;
            } else {
                cur_right.next = cur;
                cur_right = cur;
            }
        }
        cur_left.next = head_right.next;
        cur_right.next = null;

        return head_left.next;
    }
}
