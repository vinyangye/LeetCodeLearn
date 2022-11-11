package mysolution.linkedlist.twopointers.Q876_MiddleOfTheLinkedList;

/**
 * @author yeyang
 * @Date 11/11/22
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode middleNode(ListNode head) {


        // two pointers
        ListNode cur = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            cur = cur.next;
        }

        return cur;
    }
}
