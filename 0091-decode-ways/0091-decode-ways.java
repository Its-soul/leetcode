class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0 || s.charAt(0) == '0') return 0;
        int digit1 = 1;
        int digit2 = 1;
        for(int i=2; i<=n; i++){
            int count = 0;
            if(s.charAt(i-1) != '0') count += digit1;
            int twoDigit = Integer.parseInt(s.substring(i-2,i));
            if(twoDigit >= 10 && twoDigit <= 26) count += digit2;
            digit2 = digit1;
            digit1 = count;
        }return digit1;
    }
}