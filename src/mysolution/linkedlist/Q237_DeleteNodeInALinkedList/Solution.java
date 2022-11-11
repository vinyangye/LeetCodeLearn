package mysolution.linkedlist.Q237_DeleteNodeInALinkedList;

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

    // delete the next one
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
