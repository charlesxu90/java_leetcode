/***
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.ArrayList;

public class Solution {

    public class IntervalCmp implements Comparator<Interval> {
        @Override
        public int compare (Interval i1, Interval i2) {
            if (i1.start < i2.start) return -1;
            if (i1.start == i2.start && i1.end < i2.end) return -1;
            if (i1.start == i2.start && i1.end == i2.end) return 0;
            return 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0)
            return intervals;
        List<Interval> ret = new ArrayList<Interval>();
        Interval[] arr = new Interval[intervals.size()];
        intervals.toArray(arr);
        Arrays.sort(arr, new IntervalCmp());
        int start = arr[0].start;
        int end = arr[0].end;
        for (int i = 1; i < arr.length; i++) {

            if (end < arr[i].start) {
                ret.add(new Interval(start, end));
                start = arr[i].start;
                end = arr[i].end;
            }else if (arr[i].end > end) {
                end = arr[i].end;
            }
        }
        ret.add(new Interval(start, end));
        return ret;
    }
}
