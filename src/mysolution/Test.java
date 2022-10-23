package mysolution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yeyang
 * @Date 2020-05-23
 */
public class Test {

    public static int strStr(String haystack, String needle) {
        Pattern pattern = Pattern.compile(needle);
        Matcher matcher = pattern.matcher(haystack);
        if (matcher.find()){
            return matcher.start();
        }
        return -1;
    }

    public static void main(String[] args) {
        int x = strStr("applle", "ll");
        System.out.println(x);
    }
}
