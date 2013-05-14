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

    // "Sum Root to Leaf Numbers"
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbers(root, 0);
   }
   
    private int sumNumbers(TreeNode root, int prev){
        if (root.left == null && root.right == null)
            return prev*10 + root.val;

        int sum = 0;
        if (root.left != null){
            sum += sumNumbers(root.left, prev*10+root.val);
        }
        if (root.right != null){
            sum += sumNumbers(root.right, prev*10+root.val);
        }
        return sum;
    }
}