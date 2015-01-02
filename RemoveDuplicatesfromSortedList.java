/***
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
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
public class RemoveDuplicatesfromSortedList {
    
    // Solution 2:  O(n) O(1)
    // Starts from the second Node.
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        int cur = head.val;
        ListNode p = head.next;
        ListNode prev = head;
        while (p != null) {
            if (p.val == cur) {
                prev.next = p.next;
                p = prev.next;
            } else {
                cur = p.val;
                prev = prev.next;
                p = p.next;
            }
        }
        return head;
    }

    public static void main (String args[]) {
        RemoveDuplicatesfromSortedList rdfsl = new RemoveDuplicatesfromSortedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        ListNode node = rdfsl.deleteDuplicates(node1);
        while (node != null) {
            System.out.printf("%d\t", node.val);
            node = node.next;
        }
        System.out.println();
    }
}
