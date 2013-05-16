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
	// http://leetcode.com/onlinejudge#question_98
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, int min, int max) {
        return (root == null || (root.val > min  && root.val < max
            && isValidBST(root.left, min, root.val)
            && isValidBST(root.right, root.val, max)));
    }
}