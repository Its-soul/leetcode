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

    static class Pair{
        TreeNode node;
        int idx;
        public Pair(TreeNode node, int idx){
            this.node= node;
            this.idx= idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root){
        int maxWd= 0;
        
        Deque<Pair> dq= new ArrayDeque<>();
        dq.offer(new Pair(root, 0));

        while(!dq.isEmpty()){
            int size = dq.size();
            int firIdx= dq.peekFirst().idx;
            int lasIdx = dq.peekLast().idx;
            maxWd= Math.max(maxWd, lasIdx-firIdx+1);

            for(int i=0; i<size; i++){
                Pair curr= dq.poll();
                TreeNode temp= curr.node;
                int indx = curr.idx;
                if(temp.left!=null){
                    dq.add(new Pair(temp.left, 2*indx+1));
                }
                if(temp.right!=null){
                    dq.add(new Pair(temp.right, 2*indx+2));
                }
            }
        }
        return maxWd;
    }
}