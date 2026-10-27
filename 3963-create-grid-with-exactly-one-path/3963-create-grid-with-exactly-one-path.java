class Solution {
    public String[] createGrid(int m, int n) {
        String[][] ans=new String[m][n];
        for(String[] arr : ans){
            Arrays.fill(arr,"#");
        }
        for(int i=0;i<n;i++){
            ans[0][i]=".";
        }
        for(int i=1;i<m;i++){
            ans[i][n-1]=".";
        }
        String[] res=new String[m];
        for(int i=0;i<m;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){                
                sb.append(ans[i][j]);
            }
            res[i]=sb.toString();
        }
        return res;
    }
}