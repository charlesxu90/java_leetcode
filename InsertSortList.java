/***
 * Sort a linked list using insertion sort.
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

public class InsertSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode ret = new ListNode(Integer.MIN_VALUE);
        ListNode result = ret;
        ListNode cur = new ListNode(-1);
        cur.next = head;

        while(cur.next != null){
            while(result.next != null && cur.next.val >= result.next.val)
                result = result.next;
            ListNode tmp = cur.next;
            cur.next = cur.next.next;

            if (result.next == null){
                tmp.next = null;
                result.next = tmp;
            }else{
                tmp.next = result.next;
                result.next = tmp;
            }
            result = ret;
        }
        return ret.next;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        InsertSortList sortlist = new InsertSortList();
        ListNode start;
        start = sortlist.insertionSortList(node1);

        System.out.print("Before sort the list is 3,2,2,1;\n after sort it is:");
        while(start.next != null){
            System.out.format("%d,", start.val);
            start = start.next;
        }
        System.out.format("%d.\n", start.val);
    }

}
