package mysolution.Q234_PalindromeLinkedlist.SolutionO1;

/**
 * @author yeyang
 * @Date 8/11/22
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public boolean isPalindrome(ListNode head) {

        if (head.next == null) {
            return true;
        }

        ListNode leftHalf = findMiddle(head);
        ListNode rightHalf = reverseList(leftHalf.next);

        ListNode cur = rightHalf;
        ListNode curLeft = head;
        while (cur != null) {
            if (cur.val != curLeft.val) {
                return false;
            }
            cur = cur.next;
            curLeft = curLeft.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;

    }

    public ListNode findMiddle(ListNode head) {
        ListNode curFast = head;
        ListNode cur = head;
        while (curFast.next != null && curFast.next.next != null) {
            curFast = curFast.next.next;
            cur = cur.next;
        }
        return cur;
    }
}
