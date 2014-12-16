/***
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *      /  \
 *     15   7
 *return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 */
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        if(root==null) return r;
        q.offer(root);
        
        boolean reversedOrder = false;
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> level = new LinkedList<Integer>();
            for(int i = 0; i < len; i++){
                TreeNode n = q.poll();
                if(reversedOrder)
                    level.add(0, n.val);// add to front
                else
                    level.add(n.val); // add to end
                if(n.left!=null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
            }
            r.add(level);
            reversedOrder = !reversedOrder;
        }
        return r;
    }
}
