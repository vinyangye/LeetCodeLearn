package mysolution.linkedlist.twopointers.Q160_IntersectionOfTwoLinkedLists;

import java.util.HashSet;

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

    public ListNode getIntersectionNodeHash(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

        HashSet<ListNode> went = new HashSet();

        while (curA != null || curB != null) {
            if (curA != null) {
                if (!went.add(curA)) {
                    return curA;
                }
                curA = curA.next;

            }
            if (curB != null) {
                if (!went.add(curB)) {
                    return curB;
                }
                curB = curB.next;
            }

        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }

        return curA;
    }
}
