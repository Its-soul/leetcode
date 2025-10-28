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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        return swap(root);
        
    }
    public TreeNode swap(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode left=swap(root.left);
        TreeNode right=swap(root.right);
        root.left=right;
        root.right=left;
        return root;
    }

}