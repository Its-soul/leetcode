class Solution {
    public int makeConnected(int n, int[][] edges) {
        int [] parent= new int [n];
        for (int i=0; i<n; i++){
            parent[i]=i;
        }
        if(edges.length<n-1) return -1;
        for(int i=0; i<edges.length; i++){
            int x= edges[i][0];
            int y= edges[i][1];
            boolean ans= union(x,y,parent);
        }
        int res=0;
        for(int i=0; i<n; i++){
            if(parent[i]==i) res++;
        }
        return res-1;
        
    }
    public int find(int x, int [] parent){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=find(parent[x], parent);
    }
    public boolean union(int x, int y, int [] parent){
        int xparent= find(x, parent);
        int yparent= find(y, parent);
        if(yparent==xparent){
            return false;
        }
        parent[xparent]= yparent;
        return true;
    }
}