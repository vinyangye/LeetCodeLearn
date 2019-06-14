package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yeyang
 * @Date 2019-05-16
 */
public class TwoSumSolution {

    public int[] twoPassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i<nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x) && map.get(x) != i) {
                return new int[]{map.get(x), i};
            }
        }

        throw new IllegalArgumentException("No such element");
    }

    public int[] onePassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No such element");
    }

    public static void main(String[] args) {

    }
}
