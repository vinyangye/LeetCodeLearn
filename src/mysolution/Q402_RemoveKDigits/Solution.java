package mysolution.Q402_RemoveKDigits;

/**
 * @author yeyang
 * @Date 6/11/22
 */
public class Solution {

    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        String res = num;
        int n = k;
        while (n > 0) {

            res = removeOne(res);
            n--;
        }
        return res;
    }

    public String removeOne(String num) {

        if (num.length() <= 1) {
            return "0";
        }
        Long min = Long.MAX_VALUE;

        int i = 0;
        while (i < num.length()) {
            String temp = removeCharAt(num, i);
            if (Long.parseLong(temp) - min < 0) {
                min = Long.parseLong(temp);
            }
            i++;
        }

        return Long.toString(min);


    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}
