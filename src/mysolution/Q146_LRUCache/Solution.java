package mysolution.Q146_LRUCache;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author yeyang
 * @Date 7/11/22
 */
public class Solution {

    class LRUCache {

        HashMap<Integer, Integer> cache;
        LinkedList<Integer> usage;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            usage = new LinkedList<>();
        }

        public int get(int key) {

            int res = cache.getOrDefault(key, -1);
            if (res != -1) {
                usage.remove(new Integer(key));
                usage.offerLast(new Integer(key));
            }

            return res;
        }

        public void put(int key, int value) {
            usage.remove(new Integer(key));
            usage.offerLast(new Integer(key));
            if (!cache.containsKey(key) && cache.size() == this.capacity) {
                cache.remove(usage.removeFirst());
            }
            cache.put(key, value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
