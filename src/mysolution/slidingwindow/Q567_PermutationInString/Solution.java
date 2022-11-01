package mysolution.slidingwindow.Q567_PermutationInString;

import java.util.HashMap;

/**
 * @author yeyang
 * @Date 1/11/22
 */
public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        for (char item: s1Chars) {
            need.put(item, need.getOrDefault(item, 0) + 1);
            window.put(item, 0);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s2Chars.length) {
            char a = s2Chars[right];
            right++;

            if (need.containsKey(a)) {
                window.put(a, window.get(a) + 1);
                if (window.get(a).equals(need.get(a))) {
                    valid++;
                }
            }

            while (right - left >= s1Chars.length) {


                if (valid == need.size()) {
                    return true;
                }
                char b = s2Chars[left];
                left++;

                if (need.containsKey(b)) {
                    if (window.get(b).equals(need.get(b))) {
                        valid--;
                    }
                    window.put(b, window.get(b) - 1);
                }
            }
        }

        return false;
    }
}
