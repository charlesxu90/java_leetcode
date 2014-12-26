/***
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 *
 * Return 3.
 *
 * f(i, j) = f(i - 1, j) + S[i] == T[j]? f(i - 1, j - 1) : 0;
 * Where f(i, j) is the number of subsequences for T[0:j] in S[0:i];
 */
public class Solution {

    public int numDistinct(String S, String T) {


    }

}