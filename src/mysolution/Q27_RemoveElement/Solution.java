package mysolution.Q27_RemoveElement;

/**
 * @author yeyang
 * @Date 24/10/22
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(new Solution().removeElementTwoWay(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }

        return size;
    }

    public int removeElementSlowFastPointer(int[] nums, int val) {
        int slowIndex = 0;

        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    public int removeElementTwoFacePointer(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= 0 && nums[right] == val) {
            right--;
        }
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) {
                right--;
            }
        }
        return left;
    }

    public int removeElementFast(int[] nums, int val) {
        int i = 0;
        for (int elem: nums){
            if (elem != val){
                nums[i] = elem;
                i++;
            }
        }
        return i;
    }

    public int removeElementTwoWay(int[] nums, int val) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }

        return right;
    }
}
