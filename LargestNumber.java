/***
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class Solution {
    public String largestNumber(int[] num) {
        int n = num.length;
        ArrayList<String> sl = new ArrayList<String>();
        for (int i = 0; i < n; i++)
            sl.add(String.valueOf(num[i]));
        Collections.sort(sl, new StringComparator());
        StringBuilder s = new StringBuilder();
        for (int i = n - 1; i >= 0; i--)
            s.append(sl.get(i));
        if (s.length() > 0 && s.charAt(0) == '0') return "0";
        return s.toString();
    }

    private class StringComparator implements Comparator <String> {
        @Override
        public int compare(String s1, String s2) {
            return (s1 + s2).compareTo(s2 + s1);
        }
    }
}
