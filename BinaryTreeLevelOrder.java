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
    // Binary Tree Level Order Traversal
    // http://leetcode.com/onlinejudge#question_102
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;
        
        TreeNode mark = new TreeNode(Integer.MIN_VALUE);
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(mark);
        q.offer(root);
        
        ArrayList<Integer> level = null;
        while(!q.isEmpty()){
            TreeNode deq = q.poll(); // dequeue
            
            if (deq == mark){
                if (level != null && !level.isEmpty()) res.add(level);
                level = new ArrayList<Integer>(); //start new level
                if (q.isEmpty()) break; // list finished
                q.offer(mark);
            } else {
                // regular node
                level.add(deq.val);
                if (deq.left != null) q.offer(deq.left);
                if (deq.right != null) q.offer(deq.right);
            }
        }
        return res;
    }
}