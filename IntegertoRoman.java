/***
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] radix = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String ret = new String();
        for (int i = 0; num > 0; i++) {
            int count = num / radix[i];
            num %= radix[i];
            for (; count > 0; count--)
                ret += symbol[i];
        }
        return ret;
    }

    public static void main (String args[]) {
        int i = 3999;
        IntegertoRoman itr = new IntegertoRoman();
        String ret = itr.intToRoman(i);

        System.out.printf("3999 converted to Roman is: %s\n", ret);
    }
}
