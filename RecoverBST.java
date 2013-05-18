/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode n1, n2; // misplaced nodes
    private TreeNode prev; // used by 
    
    // Recover Binary Search Tree
    // http://leetcode.com/onlinejudge#question_99
    public void recoverTree(TreeNode root) {
        // reset stateful members
        n1 = null;
        n2 = null;
        prev = null;
        
        traverseInOrder(root);
        
        // swap values
        int tmp = n2.val;
        n2.val = n1.val;
        n1.val = tmp;
        
    }
    
    private void traverseInOrder(TreeNode root){
        if (root == null) return; // empty node
        
        traverseInOrder(root.left); // left 
        
        if (prev == null)
            prev = root;
        else {
            if (prev.val > root.val){
            // misplacement
                if (n1 == null){
                    n1 = prev;
                }
                n2 = root; // this
            }
            prev = root; // iterate
        }
        
        traverseInOrder(root.right); // right
    }
}