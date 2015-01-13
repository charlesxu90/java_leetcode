/***
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

// Dynamic Programming:
// Function:
// f(i, j) = min{f(i + 1, j), f(i + 1, j + 1)) + V(i, j)
//
import java.util.ArrayList;
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            System.out.printf("i %d\n", i);
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
                System.out.printf("i %d, j %d, val %d\n", i, j, triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main (String args[]) {
        Triangle tri = new Triangle();
        ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();
        test.add(new ArrayList<Integer>(){{add(1);}});
        test.add(new ArrayList<Integer>(){{add(2); add(3);}});
        System.out.printf("%d\n", tri.minimumTotal(test));
    }
}
