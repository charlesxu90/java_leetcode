/***
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int dist[][] = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++)
            dist[i][0] = i;
        for (int j = 0; j <= n2; j++)
            dist[0][j] = j;

        for (int i = 1; i <= n1; i++) 
            for (int j = 1; j <= n2; j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dist[i][j] = dist[i - 1][j - 1];
                else{
                    int indist = Math.min(dist[i-1][j], dist[i][j-1]) + 1;
                    dist[i][j] = Math.min( indist, dist[i -1][j - 1] + 1);
                }
            }
        return dist[n1][n2];
    }
}
