/***
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
import java.util.Stack;
public class Solution {
    // Solution 1: O(n^2), Exceed time limit.
    // For each pair of bars, calculate area.

    // Solution 2: O(n^2)
    // Expand to left, only when current one is bigger than previous 
    public int largestRectangleArea(int[] height) {
        int maxV = 0;
        for (int i = 0; i < height.length; i++) {
            if (i + 1 < height.length && height[i] < height[i + 1])
                continue;
            int minV = height[i];
            for (int j = i; j >= 0; j--) {
                minV = Math.min(minV, height[j]);
                int area = minV * (i - j + 1);
                if (area > maxV)
                    maxV = area;
            }
        }
        return maxV;
    }

    // Solution 3: O(n)
    // Maintain a monotonically increasing height stack,
    // If meet a bar has a lower height, then calculate the areas
    // of bars higher than it.
    // Add 0 to bar height array to do calculation for all values
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stk = new Stack<Integer>();
        int ret = 0;
        int [] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        for (int i = 0; i < h.length; ) {
            if (stk.isEmpty() || h[i] > h[stk.peek()])
                stk.add(i++);
            else {
                int temp = stk.pop();
                ret = Math.max(ret, 
                        h[temp] * (stk.isEmpty() ? i : i - stk.peek() - 1));
            }
        }
        return ret;
    }
}
