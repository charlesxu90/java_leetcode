/***
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int f[] = new int [n];
        int g[] = new int [n];

        int pmin = prices[0];
        for (int i = 1; i < n; i++) {
            if (pmin > prices[i])
                pmin = prices[i];
            f[i] = prices[i] - pmin > f[i - 1] ? prices[i] - pmin : f[i - 1];
        }
        int pmax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (pmax < prices[i])
                pmax = prices[i];
            g[i] = pmax - prices[i] > g[i + 1] ? pmax - prices[i] : g[i + 1];
        }
        int mprofit = 0;
        for (int i = 0; i < n; i++)
            if (mprofit < f[i] + g[i])
                mprofit = f[i] + g[i];
        return mprofit;
    }
}
