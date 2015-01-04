/***
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
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
    // Solution 1: Recursive O(n) O(1)
    /*
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2)
            return head;

        ListNode next_group = head;
        for (int i = 0; i < k; i++) {
            if (next_group != null)
                next_group = next_group.next;
            else
                return head;
        }

        ListNode new_next_group = reverseKGroup(next_group, k);
        ListNode prev = null;
        ListNode cur = head;
        while (cur != next_group) {
            ListNode next = cur.next;
            cur.next = prev != null ? prev : new_next_group;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    */
    
    // Solution 2: Iterative O(n) O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2)
            return head;
        ListNode ret = new ListNode(0);
        ret.next = head;

        for (ListNode prev = ret, end = head; end != null; end = prev.next) {
            for (int i = 1; i < k && end != null; i++)
                end = end.next;
            if (end == null) break;
            prev = reverse(prev, prev.next, end);
        }
        return ret.next;
    }

    private ListNode reverse(ListNode prev, ListNode begin, ListNode end) {
        ListNode end_next = end.next;
        for (ListNode p = begin, cur = p.next, next = cur.next;
                cur != end_next;
                p = cur, cur = next,
                next = next != null ? next.next : null) {
            cur.next = p;
        }
        begin.next = end_next;
        prev.next = end;
        return begin;
    }


}
