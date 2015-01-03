/***
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
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
    // Solution 1: O(m + n), O(1)
    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1);
        ListNode prev = ret;
        int ai, bi, val;
        int carry = 0;
        for (ListNode pa = l1, pb = l2; pa != null || pb != null; 
                pa = pa == null ? null : pa.next,
                pb = pb == null ? null : pb.next,
                prev = prev.next) {
            ai = pa == null ? 0 : pa.val;
            bi = pb == null ? 0 : pb.val;
            val = (ai + bi + carry) % 10;
            carry = (ai + bi + carry) / 10;
            prev.next = new ListNode(val);
                }
        if (carry > 0)
            prev.next = new ListNode(carry);
        return ret.next;
    }
    */

    // Solution 2: 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1);
        ListNode cur = ret;
        int addup = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null )
                sum = l1.val + l2.val + addup;
            else if (l1 != null)
                sum = l1.val + addup;
            else 
                sum = l2.val + addup;
            cur.next = new ListNode(sum % 10);
            addup = sum / 10 == 1 ? 1 : 0;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            cur = cur.next;
        }
        if (addup == 1)
            cur.next = new ListNode(1);

        return ret.next;
    }
}
