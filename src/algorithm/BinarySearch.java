package algorithm;

/**
 * @author yeyang
 * @Date 23/10/22
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,8};
        int target = 6;
        System.out.println(new BinarySearch().BinarySearch2(nums, target));

        int left = 0;
        int right  = nums.length;

        System.out.println(new BinarySearch().BinarySearchRecursive(nums, left, right, target));
    }

//    first one to use close left and close right.
    public int BinarySearch1(int[] nums, int target) {

        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + ((right - left) >> 1);

            if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    //    first one to use close left and open right.
    public int BinarySearch2(int[] nums, int target) {

        int left = 0, right = nums.length;

        while (left < right) {
            int middle = left + ((right - left) / 2);

            if (target < nums[middle]) {
                right = middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;

    }

    public int BinarySearchRecursive(int[] nums, int left, int right, int target) {

        if (left < right) {
            int middle = left + ((right - left) / 2);

            if (target < nums[middle]) {
                return BinarySearchRecursive(nums, left, middle, target);
            } else if (target > nums[middle]) {
                return BinarySearchRecursive(nums, middle + 1, right, target);
            } else {
                return middle;
            }
        }

        return -1;

    }


}
