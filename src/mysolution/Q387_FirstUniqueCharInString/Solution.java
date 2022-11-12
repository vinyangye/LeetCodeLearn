package mysolution.Q387_FirstUniqueCharInString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yeyang
 * @Date 11/11/22
 */
public class Solution {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public int firstUniqCharQueue(String s) {
        if (s.length() == 1) {
            return 0;
        }
        Queue<Character> queue = new LinkedList();
        HashMap<Character, Integer> map = new HashMap();


        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (map.containsKey(item)) {
                queue.remove(item);
            } else {
                map.put(item, i);
                queue.offer(item);
            }

        }
        if (queue.isEmpty()) {
            return -1;
        }
        return map.get(queue.peek());
    }
}
