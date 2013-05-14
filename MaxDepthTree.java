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
    // "Maximum Depth of Binary Tree"
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        if (root.left == null && root.right == null)
            return 1;
            
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}