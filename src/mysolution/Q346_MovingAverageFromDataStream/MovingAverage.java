package mysolution.Q346_MovingAverageFromDataStream;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yeyang
 * @Date 3/11/22
 */
public class MovingAverage {

    // queue
    Queue<Integer> queue;
    int sum;
    int size;

    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        size = size;
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() < size) {
            sum += val;
            queue.offer(val);
            return (double)sum/queue.size();
        } else {
            int item = queue.poll();
            sum -= item;
            queue.offer(val);
            sum += val;
            return (double)sum/size;
        }
    }
}
