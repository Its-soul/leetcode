class Solution {
    public boolean sumGame(String num) {
        int n = num.length()/2;
        int fsum = 0;
        int lsum = 0;
        int bcount = 0;
        int acount = 0;

        for(int i=0; i<n; i++){
            if(num.charAt(i)=='?'){
                bcount++;
            }
            if(Character.isDigit(num.charAt(i))){
                fsum += num.charAt(i)-'0';
            }
            if(num.charAt(n+i)=='?'){
                acount++;
            }
            if(Character.isDigit(num.charAt(n+i))){
                lsum += num.charAt(n+i)-'0';
            }
        }

        int diff = fsum - lsum;
        int qdiff = bcount - acount;

        if ((bcount + acount) % 2 == 1) {
            return true;
        }
        
        return diff * 2 != -9 * qdiff;

    }
}