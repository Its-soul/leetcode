class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean [] vis = new boolean [n];
        Queue<Integer> qu= new LinkedList<>();
        qu.add(0);
        vis[0]= true;
        while(!qu.isEmpty()){
            int curr=  qu.remove();
            for(int i: rooms.get(curr)){
                if(!vis[i]){
                    vis[i]= true;
                    qu.add(i);
                }
            }
        }
        for(int i=0; i<n;i++){
            if (vis[i]!=true) return false;
        }
        return true;
    }
}