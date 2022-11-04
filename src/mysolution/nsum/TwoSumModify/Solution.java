package mysolution.nsum.TwoSumModify;

import java.util.Arrays;

/**
 * @author yeyang
 * @Date 4/11/22
 */
public class Solution {

    public int twoSumTwoPointers(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;
        Arrays.sort(numbers);
        int count = 0;

        while (right > left) {
            int sum = numbers[left] + numbers[right];
            int rightValue = numbers[right];
            int leftValue = numbers[left];

            if (sum > target) {
                while (right > left && numbers[right] == rightValue) {
                    right--;
                }
            } else if (sum < target) {
                while (right > left && numbers[left] == leftValue) {
                    left++;
                }
            } else if (sum == target) {
                count++;
                while (right > left && numbers[right] == rightValue) {
                    right--;
                }
                while (right > left && numbers[left] == leftValue) {
                    left++;
                }
            }
        }

        return count;

    }
}
