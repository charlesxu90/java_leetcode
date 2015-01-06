/***
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int m[] = new int [n1 + n2];
        for (int i = n1 - 1, ofs1 = 0; i >= 0; i--, ofs1++)
            for (int j = n2 -1, ofs2 = 0; j >= 0; j--, ofs2++)
                m[n1 + n2 - ofs1 - ofs2 - 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

        int add = 0, val;
        for (int t = n1 + n2 - 1; t >= 0; t--) {
            val = m[t] + add;
            add = val / 10;
            m[t] = val % 10;
        }

        StringBuffer sb = new StringBuffer();
        int s = 0;
        for (; s < m.length &&  m[s] == 0; s++);
        for (int i = s; i < n1 + n2; i++)
            sb.append(m[i]);

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
