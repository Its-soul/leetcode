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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        boolean[] hasParent = new boolean[100001];
        for (int[] d : descriptions) {
            int parent = d[0], child = d[1];
            TreeNode p = map.getOrDefault(parent, new TreeNode(parent));
            TreeNode c = map.getOrDefault(child, new TreeNode(child));
            if (d[2] == 1) {
                p.left = c;
            } else {
                p.right = c;
            }
            map.put(parent, p);
            map.put(child, c);
            hasParent[child] = true;
        }
        for (int key : map.keySet()) {
            if (!hasParent[key]) {
                return map.get(key);
            }
        }
        return null;
    }
}