/***
 * Given an array of size n, find the majority element. The majority element is the element that appears more than [ n/2 ] times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
/*
 * Moore's Voting Algorithm
 * */
public class Solution {
    public int majorityElement(int[] num) {
        int maj = 0;
        int n = num.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                maj = num[i];
                count++;
            }else if (num[i] == maj) {
                count++;
                if (count > n/2)
                    return maj;
            }else
                count--;
        }
        return maj;
    }
}
