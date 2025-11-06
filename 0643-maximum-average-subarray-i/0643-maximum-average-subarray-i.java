class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int currSum = 0;
        double currAvg = Double.NEGATIVE_INFINITY;  
        double total = Double.NEGATIVE_INFINITY;  

        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        currAvg = (double) currSum / k;
        total = Math.max(total, currAvg);

        for (int j = k; j < nums.length; j++) {
            currSum += nums[j] - nums[j - k];
            currAvg = (double) currSum / k;
            total = Math.max(total, currAvg);
        }

        return total;
    }
}
