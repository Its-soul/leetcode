class Solution {
    public boolean checkDivisibility(int n) {
        int copy = n;
        int mul = 1;
        int sum = 0;
        while (copy>0){
            sum += copy%10;
            mul *= copy%10;
            copy = copy/10;
        }
        return n % (sum+mul)==0;
    }
}