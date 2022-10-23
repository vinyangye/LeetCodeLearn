package mysolution;

import java.util.ArrayList;
import java.util.HashMap;


public class LongestSubstring {

        public static int LengthOfLongestSubstring(String s) {
            char[] charList = s.toCharArray();
            if (charList.length == 1){
                return 1;
            }else if (charList.length == 0){
                return 0;
            }
            int maxcount = 0;
            HashMap<Character,Integer> lhm = new HashMap<Character,Integer>();
            for (int i = 0; i < charList.length; i++) {
                int count = 1;
                lhm.put(charList[i], i);
                for (int j = i + 1; j < charList.length; j++) {
                    if (lhm.containsKey(charList[j])) {
                        lhm.clear();
                        if (maxcount < count) {
                            maxcount = count;
                        }
                        break;
                    }else{
                        lhm.put(charList[j], j);
                        count++;
                        if (maxcount < count) {
                            maxcount = count;
                        }
                    }

                }
            }

            return maxcount;
        }

        public static void main(String[] args){
            System.out.println(LengthOfLongestSubstring(
                    " "));
        }

}
