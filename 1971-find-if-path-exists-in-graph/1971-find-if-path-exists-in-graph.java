class Solution {
    public boolean validPath(int n, int[][] edges, int src, int des) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0; i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i= 0; i<edges.length;i++){
            int v= edges[i][0];
            int u = edges[i][1];
            adj.get(v).add(u);
            adj.get(u).add(v);
        }
        boolean [] vis = new boolean [n];
        Queue<Integer> qu= new LinkedList<>();
        vis[src]=true;
        qu.offer(src);
        while(!qu.isEmpty()){
            int curr= qu.remove();
            for(int i: adj.get(curr)){
                if(!vis[i]){
                    vis[i]=true;
                    qu.add(i);
                }
            }
        }
        return vis[des];
    }
}