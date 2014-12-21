/***
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 *
 * Return the formatted lines as:
 * [
 *   "This    is    an",
 *   "example  of text",
 *   "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 */
import java.util.List;
import java.util.ArrayList;
public class TextJustification {

    public List<String> fullJustify(String[] words, int L) {

        List<String> ret = new ArrayList<String>();
        int nofwords = words.length;
        if (nofwords == 0) 
            return ret;

        int start = 0, end;
        int len;
        while (start < nofwords) {
            StringBuffer line = new StringBuffer();

            end = start;
            len = 0; 
            while (len + (end - 1) - start <= L && end < nofwords) {
                len += words[end].length();
                end++;
            }
            if (end == nofwords && len + (end - 1) - start <= L)
                end--;
            else {
                end--;
                len -= words[end].length();
                end--;
            }

            if (end == start || end == nofwords - 1){
                // "justification.  "
                int linelength = 0;
                for (int i = start; i < end; i++) {
                    line.append(words[i]);
                    line.append(' ');
                    linelength += words[i].length() + 1; 
                }
                line.append(words[end]);
                linelength += words[end].length();
                for (int i = 0; i < L - linelength; i++) {
                    line.append(' ');
                }
            } else {
                // "This    is    an",
                // "example  of text",
                int nofspace = (L - len) / (end - start);
                int extraspace = (L - len) % (end - start);

                for (int i = start; i <= end; i++) {

                    line.append(words[i]);
                    if (i == end)
                        break;
                    for (int j = 1; j <= nofspace; j++ ){
                        line.append(' ');
                    }
                    if (extraspace > 0) {
                        line.append(' ');
                        extraspace--;
                    }
                }
            }
            ret.add(line.toString());
            start = end + 1;
        }
        return ret;
    }

    public static void main (String args[] ) {
    
        TextJustification tj = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result = new ArrayList<String>();
        result = tj.fullJustify(words, 16);
        
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("i is : %d\t", i);
            System.out.printf("Result:%s\n", result.get(i));
        }
    }
}
