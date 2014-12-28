/***
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *      1           2(abc)      3(def)
 *      4(ghi)      5(jkl)      6(mno)
 *      7(pqrs)     8(tuv)      9(wxyz)
 *      *           0(' ')      #
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LetterCombinationsofaPhoneNumber {
    List<String> keyboard = Arrays.asList(" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        StringBuffer path = new StringBuffer("");
        int digit[] = new int[digits.length() ];
        for (int i = 0; i < digits.length(); i++) {
            digit[i] = digits.charAt(i) - '0';
        }
        dfs(0, digit, path, ret);
        return ret;
    }
    private void dfs(int start, int[] digit, StringBuffer path, List<String> ret) {
        if (start == digit.length){
            String newpath = path.toString();
            ret.add(newpath);
            return;
        }
        String str = keyboard.get(digit[start]);
        for (int i = 0; i < str.length(); i++) {
            
            path.append(str.charAt(i));
            dfs(start + 1, digit, path, ret);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main (String args[]) {
        String str = "3";
        LetterCombinationsofaPhoneNumber lcpn = new LetterCombinationsofaPhoneNumber();
        List<String> ret = new ArrayList<String>();
        ret = lcpn.letterCombinations(str);
        for (int i = 0; i < ret.size(); i++) {
            System.out.printf("i %d, string %s\n", i + 1, ret.get(i));
        }

    }
}
