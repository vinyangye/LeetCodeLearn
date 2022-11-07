package mysolution.Q125_ValidPalindrome;

/**
 * @author yeyang
 * @Date 7/11/22
 */
public class Solution {

    public boolean isPalindrome(String s) {

        s = s.replaceAll("\\s+", "").toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        if (s.length() < 2) {
            return true;
        }

        int left = 0, right = s.length() - 1;

        while (right >= left) {
            if (s.charAt(right) != s.charAt(left)) {
                return false;
            }
            right--;
            left++;
        }

        return true;
    }
}
