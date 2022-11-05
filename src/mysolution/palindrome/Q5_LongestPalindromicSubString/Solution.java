package mysolution.palindrome.Q5_LongestPalindromicSubString;

/**
 * @author yeyang
 * @Date 5/11/22
 */
public class Solution {

    public String longestPalindrome(String s) {

        int size = s.length();
        char[] chars = s.toCharArray();

        if (size < 2) {
            return s;
        }

        //sliding window
        int maxLeft = 0;
        int max = 1;

        for (int i = 1; i < size; i ++) {
            if (chars[i - 1] == chars[i]) {
                int left = i - 2;
                int right = i + 1;
                while (left >= 0 && right < size && chars[left] == chars[right]) {
                    left--;
                    right++;
                }
                if (right - left - 1 > max) {
                    max = right - left - 1;
                    maxLeft = left + 1;
                }
            }
            if (i < size - 1 && chars[i - 1] == chars[i + 1]) {
                int left = i - 2;
                int right = i + 2;
                while (left >= 0 && right < size && chars[left] == chars[right]) {
                    left--;
                    right++;
                }
                if (right - left - 1 > max) {
                    max = right - left - 1;
                    maxLeft = left + 1;
                }
            }
        }

        return s.substring(maxLeft, maxLeft + max);

    }

    public String longestPalindromeBruteForce(String s) {
        int size = s.length();
        if (size < 2) {
            return s;
        }

        int max = 1;
        int maxLeft = 0;

        for (int i = 0; i < size - 1; i++) {

            for (int j = i + 1; j < size; j++) {
                String subA = s.substring(i, j + 1);
                StringBuilder sA = new StringBuilder(subA);
                sA.reverse();

                if (subA.equals(sA.toString())) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        maxLeft = i;
                    }
                }
            }
        }

        return s.substring(maxLeft, maxLeft + max);

    }
}
