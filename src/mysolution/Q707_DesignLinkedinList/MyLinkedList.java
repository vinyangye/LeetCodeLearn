package mysolution.Q707_DesignLinkedinList;

/**
 * @author yeyang
 * @Date 29/10/22
 */
public class MyLinkedList {

    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        return pre.next.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        ListNode newItem = new ListNode(val);
        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            return;
        }
        size++;
        if (index == 0) {
            newItem.next = head;
        }

        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        newItem.next = pre.next;
        pre.next = newItem;

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;

    }
}
