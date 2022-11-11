package mysolution.stack.Q682_BaseballGame;

import java.util.Stack;

/**
 * @author yeyang
 * @Date 11/11/22
 */
public class Solution {

    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("+")) {
                int x = stack.pop();

                int y = 0;
                if (!stack.isEmpty()) {
                    y = stack.peek();
                }
                stack.push(x);
                stack.push(x + y);

            } else if (operations[i].equals("D")) {
                int x = stack.peek();
                stack.push(2 * x);

            } else if (operations[i].equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;

    }
}
