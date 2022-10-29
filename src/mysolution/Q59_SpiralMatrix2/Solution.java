package mysolution.Q59_SpiralMatrix2;

/**
 * @author yeyang
 * @Date 29/10/22
 */
public class Solution {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int loop = 1;
        int start = 0;
        int value = 1;
        int i, j;

        while (loop < n/2) {
            for (j = start; j < n - loop; j++) {
                matrix[start][j] = value++;
            }
            for (i = start; i < n - loop; i++ ) {
                matrix[i][j] = value++;
            }
            for (; j >= loop; j--) {
                matrix[i][j] = value++;
            }
            for (; i >= loop; i--) {
                matrix[i][j] = value++;
            }
            loop++;
        }

        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = n * n;
        }
        return matrix;

    }

}
