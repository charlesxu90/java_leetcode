/***
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, 
 * return its missing ranges.
 *
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
 * return ["2", "4->49", "51->74", "76->99"]. 
 */

public class MissingRanges{
    List<String> findMissingRanges(int A[], int lower, int upper) {
        List<String> ret = new ArrayList<String>();
        int prev = lower - 1;
        for (int i = 0; i < A.length && A[i] < upper + 1; i++) {
            if (prev < A[i] && prev + 1 != A[i]) {
                ret.add(makeRange(prev, A[i]));
                prev = A[i];
            } else
                prev = A[i];
        }
        ret.add(makeRange(prev, upper + 1));

        return ret;
    }

    String makeRange(int lower, int upper) {
        StringBuilder sb = new StringBuilder();
        if (lower + 1 == upper - 1)
            sb.append('0' + lower + 1);
        else {
            sb.append('0' + lower + 1);
            sb.append("->");
            sb.append('0' + upper - 1);
        }
        return sb.toString();
    }
}
