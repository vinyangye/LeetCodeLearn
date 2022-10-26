package mysolution.Q75_SortColors;

/**
 * @author yeyang
 * @Date 26/10/22
 */
public class Solution {

    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int size = nums.length;
        for (int i = 1; i < size; i++) {

            for (int j = 0; j < size - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
