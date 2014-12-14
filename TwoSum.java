/***
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashtab = new HashMap<Integer, Integer> ();
        for(int i = 0; i < numbers.length; i++){
            if(hashtab.containsKey(target - numbers[i])){
                result[0] = hashtab.get(target - numbers[i]);
                result[1] = i + 1;
            }else{
                hashtab.put(numbers[i], i + 1);               
            }
        }
        return result;
    }

    public static void main(String[] args){
        TwoSum twosum = new TwoSum();

        int[] numbers = new int[] {2, 7, 11, 15};
        int target = 9;

        int[] result;
        result = twosum.twoSum(numbers, target);
        System.out.format("In [2,7,11,15], index of two values, whose sum equal to 9, are:\n %d and %d.\n", result[0], result[1]);

    }

}
