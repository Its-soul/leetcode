class Solution {
    public long lastInteger(long n) {
        return helper(1,1,n, true);        
    }
    public long helper( long head, long step, long rem, boolean left){
        if (rem==1) return head;
        if (!left && rem % 2 ==0){
            head= head+step;
        }
        rem = (rem+1)/2;
        step *= 2;
        return helper(head, step, rem, !left);
    }
}