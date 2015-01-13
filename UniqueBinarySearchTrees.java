/***
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * Inorder Traversal
 * After order by root node:
 *    1     1         2        3     3      
 *     \     \       / \      /     /       
 *      3     2     1   3    2     1        
 *     /       \            /       \       
 *    2         3          1         2      
 * No. of trees using 1 as root = 1(left = 0) * 2(right = 2)
 * No. of trees using 2 as root = 1(left = 1) * 1(right = 1)
 * No. of trees using 3 as root = 2(left = 2) * 1(right = 0)
 * f(0) = 1;
 * f(1) = 1;
 * f(k) = f(0) *(k - 1) + f(1) * f(j -2) + ... + f(k - 1) * f(0)
 *      = Sum(f(i) * f(n - i - 1)) (i = 1 ... n - 1)
 * SO it is DP problem
 */
public class Solution {
    public int numTrees(int n) {
        int ret[] = new int[n + 1];
        ret[0] = 1;
        ret[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                ret[i] += ret[j] * ret[i - 1 -j];
            }
        }
        return ret;
    }
}
