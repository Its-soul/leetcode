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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(root, targetSum, res, ans);
        return ans;
    }

    public void helper(TreeNode node, int targetSum,List<Integer> res,List<List<Integer>> ans) {
        if (node == null) return;
        res.add(node.val);
        if (node.left == null && node.right == null && targetSum == node.val) {
            ans.add(new ArrayList<>(res));
        }
        else {
            helper(node.left, targetSum- node.val, res, ans);
            helper(node.right, targetSum- node.val, res, ans);
        }
        res.remove(res.size() - 1);
    }
}