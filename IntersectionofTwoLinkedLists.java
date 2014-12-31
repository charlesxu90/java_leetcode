/***
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 *
 * For example, the following two linked lists:
 *
 * A:          a1 -> a2
 *                      \
 *                       c1 -> c2 -> c3
 *                      /            
 * B:    b1 ->  b2 -> b3
 * begin to intersect at node c1.
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
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

    // Solution 1. T: O(m + n), S: O(1)
    // Restart from beginning if one ends, then search one after one.
    /*
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            headA = headA.next;
        }
        while (p2 != null) {
            p2 = p2.next;
            headB = headB.next;
        }
        while (headA != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    */

    // Solution 2. T: O(m + n), S: O(1)
    // Link two lists together, then find match in the end.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null)
            return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while( p1 != null && p2 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == p2)
                return p1;
            if (p1 == null)
                p1 = headB;
            if (p2 == null)
                p2 = headA;
        }
        return p1;
    }
}
