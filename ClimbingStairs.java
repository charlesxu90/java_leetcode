/***
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class Solution {
    // Solution 1. Recursive O(n) right, but too slow.
    /*
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);        
    }
    */
    
    // Solution 2. Iterative O(n) O(1)
    public int climbStairs(int n) {
        int prev = 1;
        int cur = 2;
        int next = n;
        for (int i = 3; i <= n; i++){
            next = prev + cur;
            prev = cur;
            cur = next;
        }
        return next;
    }
}

