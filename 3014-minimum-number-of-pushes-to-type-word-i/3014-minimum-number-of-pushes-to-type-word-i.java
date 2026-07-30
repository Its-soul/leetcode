class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int total = 0;
        int j = 1;
        int i = 8;
        while(i <= 32 && n >0){
    
            if(n % 8 == 0){
                total += 8 *j;
                n -= 8;
            }
            else if(n % 8 != 0 && n>=8){
                total += i * 1;
                n = Math.abs(n-8);
            }
            else if(n < 8){
                total += n * j;
                break;
            }
           
            j++;
            i = i+8;
        }
        return total;
    }
}