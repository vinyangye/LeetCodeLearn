package mysolution.palindrome.Q125_ValidPalindrome;

/**
 * @author yeyang
 * @Date 5/11/22
 */
public class Solution {

    public boolean isPalindrome(String s) {

        s = s.replaceAll("\\s+", "").toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        if (s.length() < 2) {
            return true;
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        if (s.equals(sb.toString())) {
            return true;
        }
        return false;
    }
}
