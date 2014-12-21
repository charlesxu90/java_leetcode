/***
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *
 * Try to solve it in linear time/space.
 *
 * Return 0 if the array contains less than 2 elements.
 *
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] num) {
        if (num.length < 2)
            return 0;
        // find max, min, divide into n buckets
        // get max, min in each bucket 
        // find maximum dist among successive buckets
        int gmax = -1, gmin = Integer.MAX_VALUE;
        int n = num.length;
        for (int i = 0; i < n; i++){
            gmax = gmax < num[i]? num[i] : gmax;
            gmin = gmin > num[i]? num[i] : gmin;
        }
        int dist = (gmax - gmin + n - 1) / n;
        int[] bmax = new int[n + 1];
        int[] bmin = new int[n + 1];
        Arrays.fill(bmax, -1);
        Arrays.fill(bmin, -1);
        int idx;
        for (int i = 0; i < n; i++) {
            idx = (num[i] - gmin) / dist;
            bmax[idx] = bmax[idx] == -1? num[i] : Math.max(num[i], bmax[idx]);
            bmin[idx] = bmin[idx] == -1? num[i] : Math.min(num[i], bmin[idx]);
        }
        int prevMX = gmin;
        int ret = -1;
        for (int i = 0; i <= n; i++) {
            if ( bmin[i] != -1) {
                ret = (bmin[i] - prevMX > ret)? bmin[i] - prevMX : ret;
                prevMX = bmax[i];
            }
        }
        return ret;
    }

    public static void main (String args[]) {
        MaximumGap mg = new MaximumGap();
        int[] num = {1, 100000000};

        System.out.printf("MaximumGap is: %d\n", mg.maximumGap(num));
    }
}
