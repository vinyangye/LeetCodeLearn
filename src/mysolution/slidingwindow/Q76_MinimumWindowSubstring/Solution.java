package mysolution.slidingwindow.Q76_MinimumWindowSubstring;

import java.util.HashMap;

/**
 * @author yeyang
 * @Date 1/11/22
 */
public class Solution {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int start = 0, len = Integer.MAX_VALUE;
        int valid = 0;


        for (char c: tChars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        while (right < sChars.length) {
            char a = sChars[right];
            right++;

            if (need.containsKey(a)) {
                window.put(a, window.getOrDefault(a, 0) + 1);
                if (window.get(a).equals(need.get(a))) {
                    valid++;
                }

            }

            while (valid == need.size()) {
                char b = sChars[left];
                left++;

                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                if (need.containsKey(b)) {
                    if (window.get(b).equals(need.get(b))) {
                        valid--;
                    }
                    window.put(b, window.get(b) - 1);
                }
            }
        }



        return len == Integer.MAX_VALUE? "": s.substring(start, len + start);

    }
}
