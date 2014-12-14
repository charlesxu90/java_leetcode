/***
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 * For example, this binary tree is symmetric:
 * 
 *      1
 *     / \
 *    2   2
 *   / \ / \
 *  3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *     3   3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 * confused what "{1,#,2,3}" means? read more on how binary tree is serialized on OJ.
 * 
 * 
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 * 
 * Here's an example:
 *      1
 *     / \
 *    2   3
 *       /
 *      4
 *       \
 *        5
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 */

/**
 *
 * Definition for binary tree
 */

import java.util.Stack;

public class SymmetricTree{

    public boolean isSymmetric(TreeNode root) {
///*
        //Recursive
        if(root == null)
            return true;
        return symComp(root.left, root.right);
///*
/*
        //Iterative
        if(root == null)
            return true;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        s1.push(root.left);
        s2.push(root.right);

        while(!s1.isEmpty() && !s2.isEmpty()){
            TreeNode n1 = s1.pop();
            TreeNode n2 = s2.pop();

            if( n1 == null && n2 == null){
                continue;
            }else if(n1 == null || n2 == null){
                return false;
            }else if( n1.val != n2.val){
                return false;
            }else{
                s1.push(n1.left);
                s2.push(n2.right);
                s1.push(n1.right);
                s2.push(n2.left);
            }
        }
        return true;
*/
    }
    boolean symComp(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null)
            return true;
        else if (n1 == null || n2 == null)
            return false;

        if(n1.val != n2.val)
            return false;
        return symComp(n1.left, n2.right) && symComp(n1.right, n2.left);
    }

    public static void main( String[] args){

        SymmetricTree symmtree = new SymmetricTree();
/***
 * example 1:
 *      1
 *     / \
 *    2   2
 *   / \ / \
 *  3  4 4  3
 */
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(2);
        TreeNode node21 = new TreeNode(3);
        TreeNode node22 = new TreeNode(4);
        TreeNode node23 = new TreeNode(4);
        TreeNode node24 = new TreeNode(3);

        root.left = node11;
        root.right = node12;
        node11.left = node21;
        node11.right = node22;
        node12.left = node23;
        node12.right = node24;

        System.out.format("example 1: tree is %b;\n", symmtree.isSymmetric(root));

/***
 * example 2:
 *     1
 *    / \
 *   2   2
 *    \   \
 *     3   3
 */

        node11.left = null;
        node12.left = null;

        System.out.format("example 2: tree is %b.\n", symmtree.isSymmetric(root));

    }

}
