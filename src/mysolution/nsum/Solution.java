package mysolution.nsum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yeyang
 * @Date 4/11/22
 */
public class Solution {

    public List<List<Integer>> nSum(int[] nums, int n, long target, int start) {

        List<List<Integer>> res = new ArrayList<>();
        if (n < 2) {
            return res;
        }
        if (n == 2) {
            int left = start, right = nums.length - 1;
            while (right > left) {
                int sum = nums[left] + nums[right];
                int leftValue = nums[left], rightValue = nums[right];

                if (sum > target) {
                    while (right > left && nums[right] == rightValue) {
                        right--;
                    }
                } else if (sum < target) {
                    while (right > left && nums[left] == leftValue) {
                        left++;
                    }
                } else if (sum == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    while (right > left && nums[right] == rightValue) {
                        right--;
                    }
                    while (right > left && nums[left] == leftValue) {
                        left++;
                    }
                }

            }
        } else if (n > 2) {
            int i = start;
            while (i < nums.length) {
                long newTarget = target - nums[i];
                int temp = nums[i];
                List<List<Integer>> tempRes = nSum(nums, n - 1, newTarget, i + 1);
                for (List<Integer> item: tempRes) {
                    item.add(nums[i]);
                    res.add(item);
                }
                while (i < nums.length && nums[i] == temp) {
                    i++;
                }
            }
        }


        return res;
    }
}
