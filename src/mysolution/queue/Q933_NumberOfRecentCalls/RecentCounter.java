package mysolution.queue.Q933_NumberOfRecentCalls;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yeyang
 * @Date 11/11/22
 */
class RecentCounter {
    Queue<Integer> pings;

    public RecentCounter() {
        this.pings = new LinkedList();
    }

    public int ping(int t) {
        this.pings.offer(t);
        while (this.pings.peek() < t - 3000) {
            this.pings.poll();
        }
        return this.pings.size();
    }
}
