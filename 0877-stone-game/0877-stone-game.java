class Solution {
    public boolean stoneGame(int[] piles) {
        int alice=0;
        int bob=0;
        int i=0;
        int j=piles.length-1;
        boolean chance=true;
        while(i<j){
            int first=piles[i];
            int last=piles[j];
            if(chance){
                if(first>=last){
                    alice+=first;
                    i++;
                }else{
                    alice+=last;
                    j--;
                }
            }else{
                if(first>=last){
                    bob+=last;
                    j--;
                }else{
                    bob+=first;
                    i++;
                }
            }
            chance=!chance;

        }
        if(alice>=bob){
            return true;
        }
        return false;
    }
}