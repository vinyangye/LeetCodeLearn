package mysolution.Q622_DesignCircularQueue;

/**
 * @author yeyang
 * @Date 12/11/22
 */
class MyCircularQueue {

    int headIndex;
    int count;
    int size;
    int[] queue;

    public MyCircularQueue(int k) {
        this.size = k;
        queue = new int[k];
        count = 0;
        headIndex = 0;
    }

    public boolean enQueue(int value) {
        if (count == size) return false;

        queue[(count + headIndex) % size] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (count == 0) return false;

        headIndex = (headIndex + 1) % this.size;
        count--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[headIndex];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return queue[(headIndex + count - 1) % size];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == this.size;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode() {

    }
}