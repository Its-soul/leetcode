class Solution {
    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
        int ans = Integer.MAX_VALUE;
        int landlen = ld.length;
        int waterlen = wd.length;
        for(int i =0 ; i<landlen; i++){
            for(int j=0; j<waterlen; j++){
                int finishland = lst[i]+ld[i];
                int finishwater = wst[j]+wd[j];
                if(finishland<wst[j]){
                    finishland = wst[j]+wd[j];
                }
                else finishland+=wd[j];

                if(finishwater< lst[i]){
                    finishwater = lst[i]+ld[i];
                }
                else finishwater+=ld[i];

                ans = Math.min(ans, Math.min(finishwater, finishland));

            }
        }
        return ans;
    }
}