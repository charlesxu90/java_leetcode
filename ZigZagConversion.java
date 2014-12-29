/***
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
import java.util.ArrayList;
import java.util.StringBuffer;

public class Solution {
    // Solution 1: T, O(n), S: O(n)
    public String convert(String s, int nRows) {
        if (s.length() < nRows || nRows == 1)
            return s;
        int cycle = 2 * (nRows - 1);
        ArrayList<StringBuffer> ret = new ArrayList<StringBuffer>();
        for (int i = 0; i < nRows; i++)
            ret.add(new StringBuffer());
        int j;
        for (int i = 0; i < s.length(); i++){
            j = i % cycle;
            if (j < nRows)
                ret.get(j).append(s.charAt(i));
            else if (j >= nRows)
                ret.get(cycle - j).append(s.charAt(i));
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < nRows; i++)
            result.append(ret.get(i).toString());
        return result.toString();
    }
}
