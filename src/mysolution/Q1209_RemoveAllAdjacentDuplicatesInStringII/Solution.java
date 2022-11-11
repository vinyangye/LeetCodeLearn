package mysolution.Q1209_RemoveAllAdjacentDuplicatesInStringII;

import javafx.util.Pair;

import java.util.Stack;

/**
 * @author yeyang
 * @Date 8/11/22
 */
public class Solution {

    public String removeDuplicates(String s, int k) {
        String res = "";

        Stack<Pair<Character, Integer>> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {

            if (!stack.isEmpty() && stack.peek().getKey() == s.charAt(i)) {
                int count = stack.peek().getValue() + 1;
                if (count == k) {
                    stack.pop();
                } else {
                    Pair<Character, Integer> pair = new Pair<>(s.charAt(i), count);
                    stack.pop();
                    stack.push(pair);
                }
            } else {
                Pair<Character, Integer> pair = new Pair<>(s.charAt(i), 1);
                stack.push(pair);
            }
        }

        for (Pair<Character, Integer> item: stack) {
            int n = item.getValue();
            while (n > 0) {
                res = res + item.getKey();
                n--;
            }
        }


        return res;
    }
}
