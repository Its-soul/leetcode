class Solution {
    public int numSub(String s) {
        long count = 0;
        long curr = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '1') {
                curr++;
                count += curr;
            } else {
                curr = 0;
            }
        }
        
        return (int)(count % (Math.pow(10, 9)+7));
    }
}
