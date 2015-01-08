/***
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null)
            return head;
        ListNode n1 = head;
        ListNode n2 = head;
        while (n-- > 0) { 
            if (n2.next == null) {
                n2 = head;
                continue;
            }
            n2 = n2.next;
        }
        if (n2 == head) return head;
        while (n2.next != null) {
            n1 = n1.next;
            n2 = n2.next;
        }
        ListNode ret = n1.next;
        n1.next = null;
        n2.next = head;
        return ret;
    }
    // Solution 2: find length through iteration, link end to head, then go k % length steps
    // O(n), O(1)
}
