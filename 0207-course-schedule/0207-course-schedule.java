class Solution {
    public boolean canFinish(int V, int[][] edges) {
        int [] indeg= new int [V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length; i++){
            int v= edges[i][1];
            int u= edges[i][0];
            indeg[v]+=1;  
            adj.get(u).add(v);
        }
        Queue<Integer> qu= new LinkedList<>();
        ArrayList<Integer> ans= new ArrayList<>();
        for(int i=0; i<V; i++){
            if(indeg[i]==0){
                qu.add(i);
            }
        }
        while (!qu.isEmpty()){
            int curr= qu.poll();
            ans.add(curr);
            for(int k:adj.get(curr)){
                indeg[k]-=1;
                if(indeg[k]==0){
                    qu.offer(k);
                }
            }
                
        }
        if (ans.size()!= V){
            return false;
        }
        return true;
    }
}