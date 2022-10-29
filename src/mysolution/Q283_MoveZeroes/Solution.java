package mysolution.Q283_MoveZeroes;

/**
 * @author yeyang
 * @Date 29/10/22
 */
public class Solution {

    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }

        }
    }

    public void moveZeroesSnowball(int[] nums) {

        int snowBall = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                snowBall++;
            } else {
                if (snowBall > 0) {
                    nums[i - snowBall] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }

    public void moveZeroesTwoPointer(int[] nums) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0 && index + 1 < i) {
                nums[index] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
