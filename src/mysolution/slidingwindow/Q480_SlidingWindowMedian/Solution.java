package mysolution.slidingwindow.Q480_SlidingWindowMedian;

import java.util.Arrays;

/**
 * @author yeyang
 * @Date 2/11/22
 */
public class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int left = 0, right = k - 1;

        while (right < nums.length) {

            double resItem = getMedian(nums, left, k);
            res[left] = resItem;
            right++;
            left++;
        }

        return res;
    }

    public double getMedian(int[] nums, int left, int k) {
        if (k <= 1) {
            return nums[left];
        }
        int[] temp = Arrays.copyOfRange(nums, left, left + k);

        Arrays.sort(temp);
        if (k % 2 != 0) {
            return Double.valueOf(temp[k / 2]);
        } else {
            return ((temp[k / 2 - 1] / 2.0 + temp[k / 2] / 2.0));
        }
    }


}
