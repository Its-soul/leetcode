class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n= bits.length;
        if(bits[n-1]!=0) return false;
        int i=0;
        while(i<n-1){
            if(bits[i]==0){
                i +=1; 
            }else{
                i+=2;
            }
        }
        return i==n-1;
    }
}