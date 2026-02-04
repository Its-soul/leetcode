class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean [] vis = new boolean [n];
        // Queue<Integer> qu= new LinkedList<>();
        // qu.add(0);
        // vis[0]= true;
        // while(!qu.isEmpty()){
        //     int curr=  qu.remove();
        //     for(int i: rooms.get(curr)){
        //         if(!vis[i]){
        //             vis[i]= true;
        //             qu.add(i);
        //         }
        //     }
        // }
        helper(rooms, 0, vis);
        for(int i=0; i<n;i++){
            if (vis[i]!=true) return false;
        }
        return true;
    }
    public void helper(List<List<Integer>> adj, int curr, boolean [] vis){
        vis[curr]=true;
        for(int i=0; i<adj.get(curr).size();i++){
            int neigh = adj.get(curr).get(i);
            if(!vis[neigh]){
                helper(adj, neigh, vis);
            }
        }
        
    }
}