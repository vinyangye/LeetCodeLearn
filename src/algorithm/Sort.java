package algorithm;

/**
 * @author yeyang
 * @Date 26/10/22
 */
public class Sort {

    public void BubbleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public void SelectSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }

    public void InsertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];

            int j = i;
            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }

            if (j != i) {
                nums[j] = temp;
            }
        }
    }

    public void ShellSort(int[] nums) {
        int size = nums.length;
        int temp;
        for (int step = size / 2; step >= 1; step /= 2) {
            for (int i = step; i < size; i++) {
                temp = nums[i];
                int j = i - step;
                while (j >=0 && nums[j] > temp) {
                    nums[j + step] = nums[j];
                    j -= step;
                }
                nums[j + step] = temp;
            }

        }
    }

    public void QuickSort(int[] nums) {


    }

    public void doQuickSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int key = nums[begin];
            int i  = begin, j = end;
            while (i < j) {
                while (i < j && nums[j] > key) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }
            }
        }
    }

    public void doQuickSort2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (left < right) {
            quickSort2(nums, left, right);
        }
    }


    public void quickSort2(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = left;
            int index = pivot + 1;

            for (int i = index; i <= right; i++) {
                if (nums[i] < nums[pivot]) {
                    swap(nums, i, index);
                    index++;
                }
            }
            swap(nums, pivot, index - 1);
            quickSort2(nums, index, right);
            quickSort2(nums, left, index - 2);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
