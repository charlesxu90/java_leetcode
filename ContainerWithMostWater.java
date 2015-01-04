/***
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 */
public class Solution {
    // Solution 1: Brute force O(n^2) O(1)
    public int maxArea(int[] height) {
        int ret = 0;
        int n = height.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                temp = Math.min(height[i], height[j]) * (j - i);
                ret = temp > ret? temp : ret;
            }
        }
        return ret;
    }

    // Solution 2: O(n) O(1)
    // Move the smaller one until start and end meet.
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int result = 0;
        int area;
        while (start < end) {
            area = Math.min(height[start], height[end]) * (end - start);
            result = area >  result ? area : result;
            if (height[start] <= height[end])
                start++;
            else
                end--;
        }
        return result;
    }
}

