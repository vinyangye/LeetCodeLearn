package mysolution.Q383_RansomNote;

import java.util.HashMap;

/**
 * @author yeyang
 * @Date 8/11/22
 */
public class Solution {

    public boolean canConstructMap(String ransomNote, String magazine) {

        // loop magazine
        int size = magazine.length();
        if (ransomNote.length() > size) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap();

        for (int i = 0; i < size; i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
            if (i < ransomNote.length()) {
                map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) - 1);
            }
        }

        for (int value: map.values()) {
            if (value < 0) {
                return false;
            }
        }

        return true;
    }
}
