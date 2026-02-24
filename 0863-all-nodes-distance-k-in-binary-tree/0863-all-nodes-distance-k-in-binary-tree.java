/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        helper(root, null, map);
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(target);
        HashSet<TreeNode> vis= new HashSet<>();
        int dis=0;
        vis.add(target);
        while(!qu.isEmpty()){
            int size= qu.size();
            if(dis==k) break;
            for(int i=0; i<size; i++){
                TreeNode curr= qu.poll();
                if(curr.left!=null && !vis.contains(curr.left)){
                    vis.add(curr.left);
                    qu.offer(curr.left);
                }
                if(curr.right!=null && !vis.contains(curr.right)){
                    vis.add(curr.right);
                    qu.offer(curr.right);
                }
                TreeNode par= map.get(curr);
                if(par!=null && !vis.contains(par)){
                    vis.add(par);
                    qu.offer(par);
                }
            }
            dis++;
        }
        List<Integer> ans= new ArrayList<>();
        while(!qu.isEmpty()){
            ans.add(qu.poll().val);
        }
        return ans;
    }
    public void helper(TreeNode node, TreeNode parent, HashMap<TreeNode, TreeNode> map){
        if (node==null) return;
        map.put(node, parent);
        helper(node.left, node, map);
        helper(node.right, node, map);
    }
}