package mysolution;

/**
 * @author yeyang
 * @Date 2019-05-16
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        for (int i = 0; i<nums.length-1; i++) {
            for (int j = i + 1; j<nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] x = {0, 4, 3, 0};

        int[] r = twoSum(x, 0);
        System.out.println(r[0]+","+r[1]);
    }
}

/**
 * wrong answer, because each number could only be used once.
 * [3,2,4] [0, 0]
 * 6
 */