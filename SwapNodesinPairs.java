/***
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = new ListNode(0);
        ListNode prev, cur, next;
        ret.next = head;

        for (prev = ret, cur = head, next = head.next; 
                next != null;
                prev = cur, cur = cur.next, 
                next = cur == null? null : cur.next) {
            prev.next = next;
            cur.next = next.next;
            next.next = cur;
                }
        return ret.next;
    }
}
