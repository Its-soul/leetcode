class Solution {
    public int findCircleNum(int[][] iscon) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        int n = iscon.length;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n;i++){
            for (int j = 0; j < n; j++) {
                if (iscon[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }
        int count=0;
        boolean [] vis= new boolean [n];
        for(int i=0; i<adj.size();i++){
            if(!vis[i]){
                dfs(adj, vis, i);
                count++;
            }
        }
            
        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj , boolean [] vis, int src){
        vis[src] = true;
        for (int neighbor : adj.get(src)) {
            if (!vis[neighbor]) {
                dfs(adj, vis, neighbor);
            }
        }
    }
}