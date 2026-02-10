class Solution {
    public int[] findOrder(int V, int[][] edges) {
        int [] indeg= new int [V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length; i++){
            int v= edges[i][1];
            int u= edges[i][0];
            indeg[u]+=1;  
            adj.get(v).add(u);
        }
        Queue<Integer> qu= new LinkedList<>();
        int [] ans= new int[V];
        for(int i=0; i<V; i++){
            if(indeg[i]==0){
                qu.add(i);
            }
        }
        int ind=0;
        while (!qu.isEmpty()){
            int curr= qu.poll();
            ans[ind]=curr;
            ind++;
            
            for(int k:adj.get(curr)){
                indeg[k]--;
                if(indeg[k]==0){
                    qu.offer(k);
                }
            }
                
        }
        if(ind!=V) return  new int[0];
        return ans;
    }
}