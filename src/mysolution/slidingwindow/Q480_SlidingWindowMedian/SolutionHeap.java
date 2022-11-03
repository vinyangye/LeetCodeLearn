package mysolution.slidingwindow.Q480_SlidingWindowMedian;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author yeyang
 * @Date 2/11/22
 */
public class SolutionHeap {

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] res = new double[nums.length - k + 1];

        if (nums.length == 0 || nums == null || k == 0) {
            return res;
        }


        PriorityQueue<Integer> rightHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> leftHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        int left = 0, right = k;

        for (int i = left; i < k; i++) {
            addNum(rightHeap, leftHeap, nums[i]);
        }

        res[left] = getMedian(rightHeap, leftHeap);

        while (right < nums.length) {

            if (rightHeap.contains(nums[left])) {
                rightHeap.remove(nums[left]);
            } else {
                leftHeap.remove(nums[left]);
            }
            left++;

            addNum(rightHeap, leftHeap, nums[right]);

            res[left] = getMedian(rightHeap, leftHeap);

            right++;
        }

        return res;
    }

    public void addNum(PriorityQueue<Integer> rightHeap, PriorityQueue<Integer> leftHeap, int num) {

        if (leftHeap.size() >= rightHeap.size()) {
            leftHeap.offer(num);
            rightHeap.offer(leftHeap.poll());
        } else {
            rightHeap.offer(num);
            leftHeap.offer(rightHeap.poll());
        }
    }

    public double getMedian(PriorityQueue<Integer> rightHeap, PriorityQueue<Integer> leftHeap) {
        if (rightHeap.size() > leftHeap.size()) {
            return Double.valueOf(rightHeap.peek());
        } else if (rightHeap.size() < leftHeap.size()) {
            return Double.valueOf(leftHeap.peek());
        } else {
            return (rightHeap.peek() / 2.0 + leftHeap.peek() / 2.0);
        }
    }
}
