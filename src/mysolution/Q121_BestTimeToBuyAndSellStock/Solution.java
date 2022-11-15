package mysolution.Q121_BestTimeToBuyAndSellStock;

import java.util.PriorityQueue;

/**
 * @author yeyang
 * @Date 15/11/22
 */
public class Solution {

    public int maxProfit(int[] prices) {


        if (prices.length == 1) {
            return 0;
        }
        int profit = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int i = 0; i < prices.length; i++) {
            if (!heap.isEmpty() && prices[i] > heap.peek()) {
                int temp = prices[i] - heap.peek();
                profit = Math.max(profit, temp);
            }
            heap.offer(prices[i]);
        }
        return profit;
    }

    public int maxProfitEZ(int[] prices) {


        if (prices.length == 1) {
            return 0;
        }
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            }
        }
        return profit;
    }
}
