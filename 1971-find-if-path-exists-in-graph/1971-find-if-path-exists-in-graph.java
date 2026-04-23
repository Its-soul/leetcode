class Solution {
    int [] parent;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent= new int [n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }
        for(int i=0; i<edges.length; i++){
            int x= edges[i][0];
            int y= edges[i][1];
            union(x, y);
        }
        if(find(source)==find(destination)){
            return true;
        }
        return false;
    }

    public int find(int x){
        if(x== parent[x]){
            return x;
        }
        return parent[x]= find(parent[x]);
    }

    public void union(int x, int y){
        int parx= find(x);
        int pary= find(y);
        if(parx!=pary){
            parent[pary]=parx;
        }
        return;
    }
}