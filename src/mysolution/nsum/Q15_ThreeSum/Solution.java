package mysolution.nsum.Q15_ThreeSum;

import java.util.*;

/**
 * @author yeyang
 * @Date 4/11/22
 */
public class Solution {

    public List<List<Integer>> threeSumOver(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            for (int key: map.keySet()) {

                int item = 0 - key - nums[i];

                if (map.containsKey(item)) {
                    List<Integer> temp = new ArrayList<>();
                    if (key != item || (key == item && map.get(key) > 1)) {
                        temp.add(nums[i]);
                        temp.add(key);
                        temp.add(item);
                        Collections.sort(temp);
                        if (!res.contains(temp)) {
                            res.add(temp);
                        }
                    }
                }
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int target = 0 - nums[i];
            int temp = nums[i];
            if (i + 1 < nums.length){
                twoSum(nums, target, i + 1, res);
            }
            while (i < nums.length && nums[i] == temp) {
                i++;
            }
        }
        return res;
    }

    public void twoSum(int[] nums, int target, int index, List<List<Integer>> res) {
        int left = index, right = nums.length - 1;

        while (right > left) {
            int sum = nums[left] + nums[right];
            int leftValue = nums[left], rightValue = nums[right];
            if (sum > target) {
                while(right > left && nums[right] == rightValue){
                    right--;
                }
            } else if (sum < target) {
                while(right > left && nums[left] == leftValue){
                    left++;
                }
            } else if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[index - 1]);
                temp.add(nums[left]);
                temp.add(nums[right]);
                res.add(temp);
                while(right > left && nums[right] == rightValue){
                    right--;
                }
                while(right > left && nums[left] == leftValue){
                    left++;
                }
            }
        }
    }

}
