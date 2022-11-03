package mysolution.slidingwindow.Q480_SlidingWindowMedian;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author yeyang
 * @Date 3/11/22
 */
public class SolutionTreeSet {

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] res = new double[nums.length - k + 1];

        if (nums.length == 0 || nums == null || k == 0) {
            return res;
        }

        Comparator<Integer> compare = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;

        TreeSet<Integer> leftHeap = new TreeSet<>(compare.reversed());
        TreeSet<Integer> rightHeap = new TreeSet<>(compare);


        int left = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i >= k) {
                System.out.println(i - k);
                res[i - k] = getMedian(rightHeap, leftHeap, nums);
                if (!rightHeap.remove(i - k)) {
                    leftHeap.remove(i - k);
                }
            }
            addNum(rightHeap, leftHeap, i);
            if (i == nums.length - 1) {
                res[i - k + 1] = getMedian(rightHeap, leftHeap, nums);
            }

        }

        return res;
    }

    public void addNum(TreeSet<Integer> rightHeap, TreeSet<Integer> leftHeap, int i) {

        if (leftHeap.size() >= rightHeap.size()) {
            leftHeap.add(i);
            rightHeap.add(leftHeap.pollFirst());
        } else {
            rightHeap.add(i);
            leftHeap.add(rightHeap.pollFirst());
        }
    }

    public double getMedian(TreeSet<Integer> rightHeap, TreeSet<Integer> leftHeap, int[] nums) {
        if (rightHeap.size() > leftHeap.size()) {
            return Double.valueOf(nums[rightHeap.first()]);
        } else if (rightHeap.size() < leftHeap.size()) {
            return Double.valueOf(nums[leftHeap.first()]);
        } else {
            return (nums[rightHeap.first()] / 2.0 + nums[leftHeap.first()] / 2.0);
        }
    }
}
