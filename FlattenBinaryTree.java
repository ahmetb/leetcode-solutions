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
    // Flatten Binary Tree to Linked List
    // http://leetcode.com/onlinejudge#question_114
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        while (root != null){
            if (root.left != null){
                // there is something to flatten here
                TreeNode lastInLeft = lastInPreOrder(root.left);
                
                lastInLeft.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
    
    // return: has no children
    public TreeNode lastInPreOrder(TreeNode root){
        if (root.left == null && root.right == null)
            return root;
        
        if (root.right != null) return lastInPreOrder(root.right);
        return lastInPreOrder(root.left);
    }
}