class Solution {
    int [] parent;
    public int findCircleNum(int[][] isConnected) {
        parent = new int [isConnected.length];
        for(int i=0; i<parent.length; i++){
            parent[i]=i;
        }
        for(int i=0; i<parent.length; i++){
            for(int j=0; j<parent.length; j++){
                if(isConnected[i][j]==1){
                    union(i,j);
                }
            }

        }
        int count=0;
        for(int i=0; i<parent.length; i++){
            if(parent[i]==i){
                count++;
            }
        }
        return count;

    }
    public int find(int x){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x]);
    }
    public void union(int x, int y){
        int parx= find(x);
        int pary= find(y);
        if(parx!=pary){
            parent[pary]=parx;
        }
    }

}