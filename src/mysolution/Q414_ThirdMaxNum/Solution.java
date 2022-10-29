package mysolution.Q414_ThirdMaxNum;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author yeyang
 * @Date 28/10/22
 */
public class Solution {

    public static void main(String[] args) {

    }

    public int thirdMax(int[] nums) {
        Integer max = null;
        Integer second_max = null;
        Integer third_max = null;

        for (Integer item: nums) {
            if (item.equals(max) ||  item.equals(second_max) || item.equals(third_max)) {
                continue;
            }
            if (max == null || item > max) {
                third_max = second_max;
                second_max = max;
                max = item;
            } else if (second_max == null || item > second_max) {
                third_max = second_max;
                second_max = item;
            } else if (third_max == null || item > third_max) {
                third_max = item;
            }
        }

        if (third_max != null) {
            return third_max;
        }
        return max;
    }

    public int thirdMaxHeap(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        HashSet<Integer> taken = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (taken.contains(nums[i])) {
                continue;
            }

            if (minHeap.size() == 3) {
                if (nums[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(nums[i]);

                }
            } else {
                minHeap.add(nums[i]);
            }
            taken.add(nums[i]);
        }

        if (minHeap.size() == 2) {
            minHeap.poll();
        }
        return minHeap.peek();
    }





}
