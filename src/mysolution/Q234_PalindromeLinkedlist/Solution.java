package mysolution.Q234_PalindromeLinkedlist;

import java.util.LinkedList;

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

        ListNode curFast = head;
        ListNode cur = head;

        LinkedList<Integer> nums = new LinkedList<>();


        while (curFast != null && curFast.next != null) {
            curFast = curFast.next.next;
            nums.add(cur.val);
            cur = cur.next;
        }
        if (curFast != null && curFast.next == null) {
            cur = cur.next;
        }

        while (cur != null) {
            if (cur.val != nums.removeLast()) {
                return false;
            }
            cur = cur.next;
        }

        return true;
    }
}
