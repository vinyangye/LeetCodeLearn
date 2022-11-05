package mysolution.Q36_ValidSudoku;

import java.util.HashSet;

/**
 * @author yeyang
 * @Date 5/11/22
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] != ".".charAt(0)) {
                    String row = board[i][j] + "inRow" + i;
                    String column = board[i][j] + "inColumn" + j;
                    String box = board[i][j] + "inBox" + i/3 + j/3;
                    if (!set.add(row) || !set.add(column) || !set.add(box)) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
