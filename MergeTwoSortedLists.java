/***
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
/**
 *
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
/*    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;        
        else if (l2 == null)                    
            return l1;
        ListNode ret = new ListNode(0);
        ListNode cur;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        if (l1.val <= l2.val) {
            cur =  l1;
            cur1 = l1.next;
            cur2 = l2;
        } else {
            cur = l2;
            cur1 = l1;
            cur2 = l2.next;
        }
        ret.next = cur;

        while(cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        if (cur1 != null)
            cur.next = cur1;
        else if (cur2 != null)
            cur.next = cur2;

            return ret.next;
}
    */
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode cur = head;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
            cur.next = l1;
            l1 = l1.next;
        } else {
            cur.next = l2;
            l2 = l2.next;
        }
        cur = cur.next;
    }
    if (l1 != null) {
        cur.next = l1;
    } else {
        cur.next = l2;
    }
    return head.next;
}

}
