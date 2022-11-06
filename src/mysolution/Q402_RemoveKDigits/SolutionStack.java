package mysolution.Q402_RemoveKDigits;

import java.util.Stack;

/**
 * @author yeyang
 * @Date 6/11/22
 */
public class SolutionStack {

    public String removeKdigits(String num, int k) {

        int size = num.length();
        if (k >= size) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        int i = 0;

        while (i < size) {
            // check the stack.peek(), empty
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }

        while (res.length() > 1 && res.charAt(0) == '0') {
            res = res.substring(1);
        }

        return res;


    }
}
