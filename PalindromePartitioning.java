/***
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *
 *   [
 *       ["aa","b"],
 *       ["a","a","b"]
 *    ]
 */
public class Solution {
    
    private boolean isPalindrome(String str, int s, int e){
        while (s < e && str.charAt(s) == str.charAt(e)) {
            s++;
            e--;
        }
        return s >= e;
    }   

    // Solution 1, DFS, T: O(2^(n-1)), S: (n)
    /*
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<String>();
        dfs(s, path, ret, 0);
        return ret;
    }

    private void dfs(String str, ArrayList<String> path, ArrayList<ArrayList<String>> ret, int start) {
        if (start == str.length()) {
            ArrayList<String> newpath = new ArrayList<String>(path);
            ret.add(newpath);
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str, start, i)) {
                path.add(str.substring(start, i + 1)); // substring(sidx, eidx), eidx is exclusive
                dfs(str, path, ret, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    */

    // Solution 2, DFS, T: O(2^(n - 1)), S: O(n)
    
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<String>();
        dfs(s, path, ret, 0, 1);
        return ret;
    }
    private void dfs(String str, ArrayList<String> path, ArrayList<ArrayList<String>> ret, int prev, int start) {
        if (start == str.length()) {
            if (isPalindrome(str, prev, start - 1)) {
                path.add(str.substring(prev, start));
                ArrayList<String> newpath = new ArrayList<String>(path);
                ret.add(newpath);
                path.remove(path.size() - 1);
            }
            return;
        }
        dfs(str, path, ret, prev, start + 1);
        if (isPalindrome(str, prev, start - 1)) {
            path.add(str.substring(prev, start));
            dfs(str, path, ret, start, start + 1);
            path.remove(path.size() - 1);
        }
    }
    

    // Solution 3, not finished.
    /*
    public ArrayList<ArrayList<String>> partition(String s) {
        int n = s.size();
        boolean map[][] = new boolean[n][n];

        for(int i = n - 1; i >- 0; i--)
            for ( int j = i; j < n; j++)
                p[i][j] = s[i] == s[j] && ((j - i < 2) || p[i + 1][j - 1]);

       List<ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<ArrayList<String>>>();
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; j++) {
                if (p[i][j]) {
                    String newstr = str.substring(i, j + 1);
                    if ( j + 1 < n) {
                        for (int k = 0; k < ret.get(j + 1).size(); k++){
                            ret.get(j + 1).get(k).add(0, newstr);
                            ret.get(j + 1).get(i).remove(ret.get(i).size() - 1);
                        }
                    } else {
                        ret.get(i).remove(new ArrayList<String> (){newstr});
                    }
                }
            }
            return ret.get(0);
        }
    }
    */

}
