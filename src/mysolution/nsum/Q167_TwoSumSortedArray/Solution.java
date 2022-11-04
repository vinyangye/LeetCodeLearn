package mysolution.nsum.Q167_TwoSumSortedArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yeyang
 * @Date 4/11/22
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int item = target - numbers[i];
            if (map.containsKey(item)) {
                res[1] = i + 1;
                res[0] = map.get(item);
                return res;
            }
            map.put(numbers[i], i + 1);
        }

        return res;

    }

    public int[] twoSumTwoPointers(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;
        int[] res = new int[2];

        while (right > left) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }

        return res;

    }
}
