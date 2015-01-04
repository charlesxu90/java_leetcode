/***
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Update (2014-11-02):
 * The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.
 */
public class Solution {
    // Solution 1: T: O(n*m), S O(1). Time limit exceeded.
    /*
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        int a,b;
        for (int i = 0; i < len1; i++) {
            a = i;
            b = 0;
            boolean match = true;
            while (b < len2) {
                if (a >= len1 || haystack.charAt(a) != needle.charAt(b)) {
                    match = false;
                    break;
                } else {
                    a++;
                    b++;
                }
            }
            if (match)
                return i;
        }
        return -1;
    }
    */

    // Solution 2. Boyer-Moore string search algorithm
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        int charTable[] = makeCharTable(needle);
        int offsetTable[] = makeOffsetTable(needle);
        for (int i = needle.length() - 1, j; i < haystack.length();) {
            for (j = needle.length() - 1; needle.charAt(j) == haystack.charAt(i); --i, --j) {
                if (j == 0)
                    return i;
            }
            i += Math.max(offsetTable[needle.length() - 1 -j], charTable[haystack.charAt(i)]);
        }
        return -1;
    }

    /**
     * Makes the jump table based on the mismatched character information
     */
    private static int[] makeCharTable(char[] needle) {
        final int ALPHABET_SIZE = 256;
        int[] table = new int[ALPHABET_SIZE];
        for (int i = 0; i < table.length; ++i)
            table[i] = needle.length;
        for (int i = 0; i < needle.length - 1; ++i)
            table[needle[i]] = needle.length - 1 -i;
        return table;
    }

    /**
     * Makes the jump table based on the scan offset which mismatch occurs.
     */
    private static int[] makeOffsetTable(char[] needle) {
        int[] table = new int[needle.length];
        int lastPrefixPosition = needle.length;
        for (int i = needle.length - 1; i >= 0; --i) {
            if (isPrefix(needle, i + 1))
                lastPrefixPosition = i + 1;
            table[needle.length - 1 - i] = lastPrefixPosition - i + needle.length - 1;
        }
        for (int i = 0; i < needle.length - 1; ++i) {
            int slen = suffixLength(needle, i);
            table[slen] = needle.length - 1 - i + slen;
        }
        return table;
    }

    /**
     * Is needle[p:end] a prefix of needle?
     */
    private static boolean isPrefix(char[] needle, int p) {
        for (int i = p, j = 0; i < needle.length; ++i, ++j) {
            if (needle[i] != needle[j])
                return false;
        }
        return true;
    }

    /**
     * Returns the maximum length of the substring ends ta p and is a suffix.
     */
    private static int suffixLength(char[] needle, int p) {
        int len = 0;
        for ( int i = p, j = needle.length - 1;
                i >= 0 && needle[i] == needle[j];
                --i, --j) {
            len += 1;
                }
        return len;
    }
}
