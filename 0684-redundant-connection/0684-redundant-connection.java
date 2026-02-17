class Solution {
    static int [] ans =new int [2];
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length+1;
        int [] parent= new int [n];
        for (int i=1; i<n; i++){
            parent[i]=i;
        }
        for(int i=0; i<edges.length; i++){
            int x= edges[i][0];
            int y= edges[i][1];
            if(!union(x,y,parent)){
                ans[0]=x;
                ans[1]=y;
            }
        }
        return ans;
        
    }
    public int find(int x, int [] parent){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=find(parent[x], parent);
    }
    public boolean union(int x, int y, int [] parent){
        int xparent= find(parent[x], parent);
        int yparent= find(parent[y], parent);
        if(yparent==xparent){
            return false;
        }
        parent[xparent]= yparent;
        return true;
    }
}