package mysolution.slidingwindow.Q3_LongestSubstring;

import java.util.HashMap;

/**
 * @author yeyang
 * @Date 31/10/22
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        char[] string = s.toCharArray();
        int size = string.length;
        int res = 0;

        int left = 0, right = 0;

        while (right < size) {
            Character a = string[right];
            right++;
            window.put(a, window.getOrDefault(a, 0) + 1);

            while (window.get(a) > 1) {
                Character b = string[left];
                left++;
                window.put(b, window.get(b) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
