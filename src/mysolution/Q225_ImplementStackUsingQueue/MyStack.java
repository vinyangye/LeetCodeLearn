package mysolution.Q225_ImplementStackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yeyang
 * @Date 12/11/22
 */
public class MyStack {

        Queue<Integer> q = new LinkedList();

        public MyStack() {
        }

        public void push(int x) {
            q.offer(x);
            int count = 0;
            while (count != q.size() - 1) {
                q.offer(q.poll());
                count++;
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }

}
