package mysolution.Q485_MaxConsecutiveOnes;

/**
 * @author yeyang
 * @Date 25/10/22
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,0};
        System.out.println(new Solution().findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == 1) {
                count += 1;
            } else {
                count = 0;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
