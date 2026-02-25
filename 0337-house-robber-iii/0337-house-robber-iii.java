/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int [] choice = helper(root);
        return Math.max(choice[0], choice[1]);
    }
    public int [] helper(TreeNode root){
        if(root==null) return new int [2];
        int [] left= helper(root.left);
        int [] right= helper(root.right);
        int [] ch= new int [2];
        ch[0]= root.val + left[1]+ right[1]; //take
        ch[1]= Math.max(left[0], left[1])+ Math.max(right[0], right[1]);
        return ch;
    }
}