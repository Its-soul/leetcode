class Solution {
    public boolean canAliceWin(int n) {
        int x=10;
        if(n<10){
            return false;
        }

        while(n>0){
            if(x>n){
                return !(x%2==0);
            }
            n-=x--;
        }
        if(x==0 || x%2 == 0){
            return false;
        }
        else{
            return true;
        }
    }
}