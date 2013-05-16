/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SameTree {
	// Same Tree
	// http://leetcode.com/onlinejudge#question_100
    public boolean isSameTree(TreeNode p, TreeNode a) {
        if (p == null || a==null) return p==a;
        return p.val == a.val && isSameTree(p.left,a.left) && isSameTree(p.right, a.right);
    }
}