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
    // Balanced Binary Tree (LOL I solved this in about a minute)
    // http://leetcode.com/onlinejudge#question_110
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
    
    public int depth(TreeNode root){
        if (root == null)
            return 0; // empty node, stop case
        
        int depthL = depth(root.left);
        if (depthL == -1) return -1; // indicates inbalanced children occurrence, propagate up

        int depthR = depth(root.right);
        if (depthR == -1) return -1; // indicates inbalanced children occurrence, propagate up

        if (Math.abs(depthL - depthR) > 1)
            return -1; // indicates inbalanced children
        
        return Math.max(depthL, depthR) + 1;
    }
}