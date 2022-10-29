package mysolution.Q209_MinimiumSizeSubarraySum;

/**
 * @author yeyang
 * @Date 29/10/22
 */
public class Solution {

    public int minSubArrayLen(int target, int[] nums) {

        int count = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= target) {
                return 1;
            }
            int sum = nums[i];
            int currentCount = 1;
            for (int j = i + 1; j< nums.length; j++) {
                sum += nums[j];
                currentCount += 1;

                if (sum >= target) {

                    count = Math.min(count, currentCount);
                    break;
                }
            }
            if (sum < target && i == 0 ) {
                return 0;
            }
        }

        return count;
    }

    public int minSubArrayLenSlidingWindow(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;

    }
}
