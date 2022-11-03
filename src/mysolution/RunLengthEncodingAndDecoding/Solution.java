package mysolution.RunLengthEncodingAndDecoding;

import java.util.LinkedHashMap;

/**
 * @author yeyang
 * @Date 3/11/22
 */
public class Solution {

    public static void encoding(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = str.toCharArray();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }

        for (char key: map.keySet()) {
            res.append(key).append(map.get(key));
        }
        str = str.toString();
    }

    public static void encodingNew(String str) {
        char[] chars = str.toCharArray();
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {

            int count = 1;
            while (i < chars.length - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count += 1;
                i++;
            }
            s.append(str.charAt(i)).append(count);
        }
        str = s.toString();
    }
}
