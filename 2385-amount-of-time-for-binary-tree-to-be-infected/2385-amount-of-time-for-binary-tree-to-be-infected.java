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
    int str;
    TreeNode src;
    public int amountOfTime(TreeNode root, int start) {
        str = start;
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        parentfill(map,root, null);
        Queue<TreeNode> qu= new LinkedList<>();
        HashSet<TreeNode> vis = new HashSet<>();
        vis.add(src);
        qu.offer(src);
        int dis=0;
        while(!qu.isEmpty()){
            int size= qu.size();
            for(int i=0; i<size; i++){
                TreeNode curr = qu.poll();
                if(curr.left!=null && !vis.contains(curr.left)){
                    vis.add(curr.left);
                    qu.add(curr.left);
                }
                if(curr.right!=null && !vis.contains(curr.right)){
                    vis.add(curr.right);
                    qu.add(curr.right);
                }
                TreeNode par= map.get(curr);
                if(par!=null && !vis.contains(par)){
                    vis.add(par);
                    qu.add(par);
                }

            }
            dis++;
        }
        return dis-1;
    }  

    public void parentfill(HashMap<TreeNode,TreeNode> Parent, TreeNode root, TreeNode parent ){
        if ( root == null) return ;
        parentfill(Parent,root.left, root);
        Parent.put(root,parent);
        if(root.val == str ) src = root;
        parentfill(Parent,root.right, root);
    }
}
