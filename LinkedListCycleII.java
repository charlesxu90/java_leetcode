/***
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
/**
  * Definition for singly-linked list.
  * class ListNode {
  *     int val;
  *     ListNode next;
  *     ListNode(int x) {
  *         val = x;
  *         next = null;
  *     }
  * }
  */
//  (------x------|--a--M---|) : Total Length L, M is meet point
//  x = (n - 1)r + (L - x - a)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head, slow2 = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2;
            }
        }
        return null;
    }
}
