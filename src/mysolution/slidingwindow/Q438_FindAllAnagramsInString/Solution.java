package mysolution.slidingwindow.Q438_FindAllAnagramsInString;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yeyang
 * @Date 1/11/22
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        for (char item: pChars) {
            need.put(item, need.getOrDefault(item, 0) + 1);
            window.put(item, 0);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < sChars.length) {
            char a = sChars[right];
            right++;

            if (need.containsKey(a)) {
                window.put(a, window.get(a) + 1);
                if (window.get(a).equals(need.get(a))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                char b = sChars[left];

                if (need.containsKey(b)) {
                    if (window.get(b).equals(need.get(b))) {
                        if (right - left == pChars.length) {
                            result.add(left);
                        }
                        valid--;
                    }
                    window.put(b, window.get(b) - 1);
                }
                left++;

            }
        }
        return result;

    }

    public List<Integer> findAnagramsOther(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        for (char item: pChars) {
            need.put(item, need.getOrDefault(item, 0) + 1);
            window.put(item, 0);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < sChars.length) {
            char a = sChars[right];
            right++;

            if (need.containsKey(a)) {
                window.put(a, window.get(a) + 1);
                if (window.get(a).equals(need.get(a))) {
                    valid++;
                }
            }

            while (right - left >= pChars.length) {
                char b = sChars[left];
                if (valid == need.size()) {
                    result.add(left);
                }
                left++;

                if (need.containsKey(b)) {
                    if (window.get(b).equals(need.get(b))) {
                        valid--;
                    }
                    window.put(b, window.get(b) - 1);
                }


            }
        }
        return result;

    }
}
