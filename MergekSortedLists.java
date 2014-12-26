/***
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
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

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {

    // Solution 1. NOt complete 
    /*    public ListNode mergeKLists(List<ListNode> lists) {
        if(checkAllNull(lists))
            return null;
        ListNode ret = new ListNode(0);
        ListNode cur = ret;
        ListNode nextnode;
        while ( !checkAllNull(lists)) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            ListNode curLists;
            for (int i = 0; i < lists.size(); i++) {
                curLists = lists.get(i);
                System.out.printf("index in list %d\n", i);
                if (curLists == null) continue;
                System.out.printf("value %d\n", curLists.val);
                if (curLists.val < min) {
                    min = curLists.val;
                    minIndex = i;
                }
            }
            System.out.printf("min value index %d\n", minIndex);
            nextnode = lists.get(minIndex); 
            cur.next = nextnode;
            lists.remove(minIndex);
            lists.add(minIndex, nextnode.next);
            cur = cur.next;
        }
        cur.next = null;

        return ret.next;
    }

    private boolean checkAllNull(List<ListNode> lists) {
        for (int i = 0; i < lists.size(); i++)
            if (lists.get(i) != null)
                return false;
        return true;
    }
    */
    // Solution 2. S: O(Nnodes), T: O(Nnodes + Nlists)
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.isEmpty())
            return null;

        Comparator<ListNode> comp = new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                if (o1.val > o2.val)
                    return 1;
                return 0;
            }
        };
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
                lists.size(), comp);
        for (ListNode node : lists) {
            if (node != null)
                heap.add(node);
        }
        ListNode head = null, cur = null;
        while (!heap.isEmpty()) {
            if (head == null) {
                head = heap.poll();
                cur = head;
            } else {
                cur.next = heap.poll();
                cur = cur.next;
            }
            if (cur.next != null)
                heap.add(cur.next);
        }
        return head;
    }


    public static void main( String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = null;
        ListNode n3 = new ListNode(2);
        n1.next = n3;
        ArrayList<ListNode> lists = new ArrayList();
        lists.add(n1);
        lists.add(n2);
        MergekSortedLists mkst = new MergekSortedLists();
        ListNode ret = mkst.mergeKLists(lists);

        while (ret != null){
            System.out.printf("value %d", ret.val);
            ret = ret.next;
        }
 
    }
}
