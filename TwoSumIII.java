/***
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * 
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * 
 * For example,
 *
 *   add(1); add(3); add(5);
 *   find(4) -> true
 *   find(7) -> false
 */
public class Solution {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public void add(int number) {
        if (map.containsKey(number))
            map.put(number, map.get(number) + 1);
        else 
            map.put(number, 1);
    }

    boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if (!map.containsKey(value - entry.getKey()))
                continue;
            else {
                if (value == 2 * entry.getKey() && entry.getValue() == 1)
                    continue;
                return true;
            }
        }
        return false;
    }
}
