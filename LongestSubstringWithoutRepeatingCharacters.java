/***
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters{
    public int lengthOfLongestSubstring(String s) {
        // using hash to record the nearest occur location
        HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        int j = 0;// index of nearest duplicate
        int result = 0;
        while(i < s.length()){
            Integer c = new Integer(s.charAt(i));
            if(!map.containsKey(c)){
                map.put(c, i);
            }else{
                int length = i - j;
                if(result < length)
                    result = length;

                Integer index = map.get(c);
                j = Math.max(j, index + 1);
                map.put(c, i);
            }
            i++;

        }

        if (i - j > result)
            result = i - j;

        return result;

    }
}
