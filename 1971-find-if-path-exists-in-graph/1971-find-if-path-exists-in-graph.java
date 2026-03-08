class Solution {
    static int[] parent;
    static int[] rank;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent=new int[n];
        rank=new int[n];

        for(int i=0; i<n ; i++){
            parent[i]=i;
        }
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            union(u,v);
        }
        return find(source)==find(destination);
    }
    public int find(int x){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x]);
    }
    public boolean union(int x, int y){
        int px=find(x);
        int py=find(y);

        if(px==py) return false;

        if(rank[px]>rank[py]){
            parent[py]=px;
        }
        else if(rank[px]<rank[py]){
            parent[px]=py;
        }
        else{
            parent[px]=py;
            rank[py]++;
        }
        return true;
    }
}