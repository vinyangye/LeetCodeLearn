package mysolution.Q1480_SumOf1DArray;

/**
 * @author yeyang
 * @Date 23/10/22
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        int[] r = RunningSum2(nums);
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }

    public static int[] RunningSum(int[] nums) {

        int[] sums = new int[nums.length];
        sums[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }

        }

        return sums;
    }

    public static int[] RunningSum1(int[] nums) {

        int[] sums = new int[nums.length];
        sums[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        return sums;
    }

    public static int[] RunningSum2(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }
}
