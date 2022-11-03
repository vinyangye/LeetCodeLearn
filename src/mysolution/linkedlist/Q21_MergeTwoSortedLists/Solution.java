package mysolution.linkedlist.Q21_MergeTwoSortedLists;

/**
 * @author yeyang
 * @Date 1/11/22
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode pre = new ListNode(-101, list2);
        ListNode start = pre;
        while (cur1 != null) {
            while (cur2 != null && cur1.val > cur2.val) {
                pre = cur2;
                cur2 = cur2.next;
            }
            System.out.println("***************");
            System.out.println(cur1.val);
            ListNode temp = new ListNode(cur1.val, cur2);
            pre.next = temp;
            pre = pre.next;
            cur1 = cur1.next;

        }
        return start.next;
    }
}
