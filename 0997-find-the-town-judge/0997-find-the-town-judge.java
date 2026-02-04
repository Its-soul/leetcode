class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] indegre= new int [n+1];
        int ans=-1;
        int [] outdegre= new int [n+1];
        for(int i=0;i<trust.length; i++){
            for(int j=0; j<1; j++){
                int u=  trust[i][0];
                int v= trust [i][1];
                indegre[v]+=1;
                outdegre[u]+=1;
            }
        }
        for(int i=1;i<indegre.length;i++){
            if(indegre[i]==n-1 && outdegre[i]==0){
                ans=i;
                break;
            }
        }
        return ans;

    }
}