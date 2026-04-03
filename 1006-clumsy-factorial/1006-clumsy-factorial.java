class Solution {
    public static int md(int n){
        if(n==2){
            return 2;
        }
        if(n==1){
            return 1;
        }
        return (n*(n-1))/(n-2);
    }
    public int clumsy(int n) {
        int ans=0;
        boolean first=true;
        while(n>0){
            if(first){
                ans+=md(n);
                first=false;
            }
            else{
                   ans-=md(n);
            }
            n=n-3;
            if(n>0){
                ans+=n;
                n--;
            }
        }
        return ans;
    }
}