package mysolution.Q215_KthLargestElementInArray;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author yeyang
 * @Date 7/11/22
 */
public class Solution {

    public int findKthLargestHeap(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public int findKthLargest(int[] nums, int k) {

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);

    }

    public int quickSelect(int[] nums, int left, int right, int kSmallest) {
        if (left == right) {
            return nums[left];
        }

        int pivot = left + new Random().nextInt(right - left);

        int partition = partition(nums, left, right, pivot);

        if (partition == kSmallest) {
            return nums[partition];
        } else if (partition < kSmallest) {
            return quickSelect(nums, partition + 1, right, kSmallest);
        } else {
            return quickSelect(nums, left, partition - 1, kSmallest);
        }
    }

    public int partition(int[] nums, int left, int right, int pivot) {
        int pivotValue = nums[pivot];
        swap(nums, pivot, right);
        int index = left;

        for (int i = left; i <= right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, index);
                index++;
            }
        }

        swap(nums, index, right);
        return index;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
