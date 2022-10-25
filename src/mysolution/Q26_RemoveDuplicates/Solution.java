package mysolution.Q26_RemoveDuplicates;

/**
 * @author yeyang
 * @Date 25/10/22
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Solution().removeDuplicatesLeet(nums));
    }

    public int removeDuplicates(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            if (nums[slowIndex] != nums[fastIndex]) {
                slowIndex++;
                nums[slowIndex] = nums[fastIndex];
            }
        }
        return slowIndex+1;
    }

    public int removeDuplicatesFast(int[] nums) {
        int slowIndex = 0;
        for (int item: nums) {
            if (nums[slowIndex] != item) {
                slowIndex++;
                nums[slowIndex] = item;
            }
        }
        return slowIndex+1;
    }

    public int removeDuplicatesLeet(int[] nums) {
        int slowIndex = 1;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex - 1] != nums[fastIndex]) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
