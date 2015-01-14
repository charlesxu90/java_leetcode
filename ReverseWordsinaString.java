/***
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Clarification:
 *   What constitutes a word?
 *      A sequence of non-space characters constitutes a word.
 *   Could the input string contain leading or trailing spaces?
 *      Yes. However, your reversed string should not contain leading or trailing spaces.
 *   How about multiple spaces between two words?
 *      Reduce them to a single space in the reversed string.
 */
public class Solution {
    // Solution 1: Recursive O(n) O(n^2)
    public String reverseWords(String s) {
        char charArr[] = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ')
                return Reverse(s.substring(i + 1)) + s.substring(0, i) + " ";
        }
        return s + " ";
    }

    // Solution 2: Using split, regex O(n)
    public String reverseWords(String s) {
        StringBuilder ret = new StringBuilder();
        String[] words = s.split("\\s+");
        for (int i = words.length - 1; i >= 0; i--) {
            ret.append(words[i]).append(' ');
        }
        return ret.toString().trim();
    }
}
