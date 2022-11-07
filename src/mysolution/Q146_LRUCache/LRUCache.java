package mysolution.Q146_LRUCache;

import java.util.HashMap;

/**
 * @author yeyang
 * @Date 7/11/22
 */
class LRUCache {

    class ListNode {
        int key;
        int value;
        ListNode pre;
        ListNode next;
    }

    private void addNode(ListNode node) {
        // add node next to head
        node.pre = head;
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
    }

    private void removeNode(ListNode node) {
        ListNode preNode = node.pre;
        ListNode nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    private void moveToHead(ListNode node) {
        removeNode(node);
        addNode(node);
    }

    private ListNode popTail() {
        ListNode node = tail.pre;
        removeNode(node);
        return node;
    }

    private HashMap<Integer, ListNode> cache;
    private ListNode head, tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {

        ListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);

        if (node == null) {
            node = new ListNode();
            node.key = key;
            node.value = value;
            addNode(node);
            if (cache.size() == this.capacity) {
                cache.remove(popTail().key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

        cache.put(key, node);
    }
}