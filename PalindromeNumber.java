/***
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Could negative integers be palindromes? (ie, -1)
 *
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 *
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 *
 * There is a more generic way of solving this problem.
 */

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int d = 1;  // divisor
        while(x / d >= 10) d *= 10;
        int q;  // quotient
        int r;  // remainder
        while(x > 0) {
            q = x / d;
            r = x % 10;
            if (q != r) return false;
            x = x % d / 10;
            d /= 100;
        }
        return true;
    }
}
