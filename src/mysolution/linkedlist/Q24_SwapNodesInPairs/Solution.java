package mysolution.linkedlist.Q24_SwapNodesInPairs;

/**
 * @author yeyang
 * @Date 30/10/22
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode newHead = cur;
        ListNode temp = null;

        while (cur != null) {
            if (cur.next != null) {
                temp = cur.next;
                pre.next = temp.next;
                cur.next = pre;
                pre = temp;
                cur = temp.next;
            }
        }
        return newHead;
    }
}
