/***
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 *
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

public class Solution {

    // Solution: BFS, worst case T(26^L * size(dict)), L is word length.
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || start.length() == 0|| end.length() == 0) 
            return 0;
        int level = 1;
        int lastnum = 1;    // record the level of nodes to visit
        int curnum = 0;     // record next level of nodes

        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();

        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            lastnum--;
            for (int i = 0; i < cur.length(); i++) {
                char charCur[] = cur.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    charCur[i] = c;
                    String temp = new String(charCur);
                    if (temp.equals(end))
                        return level + 1;
                    if (dict.contains(temp) && !visited.contains(temp) {
                        curnum++;
                        queue.add(temp);
                        visited.add(temp);
                    }
                }
            }
            if (lastnum == 0) {//update lastnum when previous level is finished
                lastnum = curnum;
                curnum = 0;
                level++;
            }
        }
        return 0;
    }
}
