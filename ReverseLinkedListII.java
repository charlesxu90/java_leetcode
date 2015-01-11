/***
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 <= m <= n <= length of list.
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
public class ReverseLinkedListII {
    // Solution: O(n) O(1)
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode ret = new ListNode(0);
        ret.next = head;
        ListNode prev = ret;
        int kk = m;
        while (--kk > 0)
            prev = prev.next;
        ListNode head2 = prev;
        System.out.printf("head2 val: %d\n", head2.val);

        prev = prev.next;
        ListNode cur = prev.next;
        for (int i = m; i < n; ++i) {
            // do as follows
            // 0: 1 - 2 - 3. - 4
            // 1: 1 - (3) - 2 - 4.
            // 2: 1 - (4) - 3 - 2
            System.out.printf("i: %d, cur: %d\t", i, cur.val);
            prev.next = cur.next;
            cur.next = head2.next;
            head2.next = cur;
            cur = prev.next;
        }
        System.out.println();
        return ret.next;
    }
    public static void main (String args[] ) {
        ReverseLinkedListII rll2 = new ReverseLinkedListII();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode head = rll2.reverseBetween(n1, 1, 2);
        while (head != null) {
            System.out.printf("val %d\n", head.val);
            head = head.next;
        }
    }
}
