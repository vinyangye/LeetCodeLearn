package mysolution.Q977_SquaresOfSortedArray;

/**
 * @author yeyang
 * @Date 29/10/22
 */
public class Solution {

    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int index = nums.length - 1;
        int[] res = new int[nums.length];

        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[index] = nums[left] * nums[left];
                index--;
                left++;
            } else {
                res[index] = nums[right] * nums[right];
                right--;
                index--;
            }
        }

        return res;

    }
}
