/***
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

public class ReorderList {

    public ListNode reorderList (ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = midNode(head);
        ListNode last;
        last = reverseList(mid.next);
        mid.next = null;

        ListNode ret = new ListNode(0);
        ret.next = head;
        ListNode cur = new ListNode(0);
        while (head != null && last != null) {
            cur.next = head;
            head = head.next;
            cur = cur.next;
            cur.next = last;
            last = last.next;
            cur = cur.next;
        }
        if ( head != null) {
            cur.next = head;
            cur = cur.next;
        }
        cur.next = null;
        head = ret.next;
        return head;
    }

    private ListNode midNode (ListNode head) {

        //  idea: two cursors: V(1) = 2 * v(2)
        // final location of 1 is mid point
        ListNode slow = head;
        ListNode fast = head;
        while ( fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        } 
        return slow;
    }

    private ListNode reverseList (ListNode mid) {
        ListNode cur = mid;
        ListNode prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        } 
        return prev;
    }

    public static void main (String args[]) {

        ReorderList rl = new ReorderList();
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        ListNode d1 = rl.reorderList(h1);
        ListNode d2 = d1.next;
        ListNode d3 = d2.next;
        ListNode d4 = d3.next;
        System.out.printf("Reorder of {1,2,3,4} is: %d, %d, %d, %d", d1.val, d2.val, d3.val, d4.val);

    }
}
