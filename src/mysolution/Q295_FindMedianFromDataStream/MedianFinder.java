package mysolution.Q295_FindMedianFromDataStream;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author yeyang
 * @Date 3/11/22
 */
public class MedianFinder {

    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;

    public MedianFinder() {
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        leftHeap.offer(num);
        rightHeap.offer(leftHeap.poll());
        if (rightHeap.size() > leftHeap.size())
            leftHeap.offer(rightHeap.poll());
        // if (leftHeap.size() >= rightHeap.size()) {
        //     leftHeap.offer(num);
        //     rightHeap.offer(leftHeap.poll());
        // } else {
        //     rightHeap.offer(num);
        //     leftHeap.offer(rightHeap.poll());
        // }
    }

    public double findMedian() {
        if (leftHeap.size() > rightHeap.size()) {
            return (double)leftHeap.peek();
        } else if (rightHeap.size() > leftHeap.size()) {
            return (double)rightHeap.peek();
        } else {
            return ((double)rightHeap.peek() + (double)leftHeap.peek()) / 2;
        }
    }
}
