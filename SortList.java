/***
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
/**
 *
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
public class Solution {
    // Sorting algorithms:
    // 3.1 Simple sorts
    //  3.1.1 Insertion sort: T: O(n^2)
    //  3.1.2 Selection sort: T: O(n^2)
    // 3.2 Efficient sorts
    //  3.2.1 Merge sort: T: O(n long n)
    //  3.2.2 Heapsort: O(n long n)
    //  3.2.3 Quicksort: T: O(n^2) in worst case
    // 3.3 Bubble sort and variants
    //  3.3.1 Bubble sort: T: O(n^2)
    //  3.3.2 Shell sort
    //  3.3.3 Comb sort
    // 3.4 Distribution sort
    //  3.4.1 Counting sort
    //  3.4.2 Bucket sort
    //  3.4.3 Radix sort
    
    // Mergesort suits single linked list;
    // Quicksort suits double linked list.
    public ListNode sortList(ListNode head) {
        // Here we choose merge sort
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = sortList(head);
        fast = sortList(fast);
        return merge(slow, fast);
    }

    private ListNode merge(ListNode slow, ListNode fast) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while(slow != null && fast != null) {
            if (slow.val < fast.val) {
                cur.next = slow;
                slow = slow.next;
            } else {
                cur.next = fast;
                fast = fast.next;
            }
            cur = cur.next;
        }

        if (slow != null) {
            cur.next = slow;
        } else if (fast != null) {
            cur.next = fast;
        }
        return head.next;
    }
}
