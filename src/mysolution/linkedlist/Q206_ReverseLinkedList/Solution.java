package mysolution.linkedlist.Q206_ReverseLinkedList;

/**
 * @author yeyang
 * @Date 30/10/22
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
//        ListNode cur = head;
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        head.next = null;

        while (cur != null) {
            ListNode after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }
        return pre;

    }

    public ListNode reverseListRecursive(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return cur;
        }
        ListNode after = cur.next;
        cur.next = pre;
        return reverse(cur, after);
    }

    public ListNode reverseListReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseListReverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;

    }

}
