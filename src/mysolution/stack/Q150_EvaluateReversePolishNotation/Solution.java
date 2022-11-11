package mysolution.stack.Q150_EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * @author yeyang
 * @Date 11/11/22
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (tokens[i].equals("-")) {
                int x = stack.pop();
                stack.push(stack.pop() - x);
            } else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i].equals("/")) {
                int x = stack.pop();
                stack.push(stack.pop() / x);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
