class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minFinish = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;

        int minLandEnd = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minLandEnd = Math.min(minLandEnd, landStartTime[i] + landDuration[i]);
        }
        int minWaterEnd = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minWaterEnd = Math.min(minWaterEnd, waterStartTime[j] + waterDuration[j]);
        }
        for (int j = 0; j < m; j++) {
            int plan1 = Math.max(minLandEnd, waterStartTime[j]) + waterDuration[j];
            minFinish = Math.min(minFinish, plan1);
        }
        for (int i = 0; i < n; i++) {
            int plan2 = Math.max(minWaterEnd, landStartTime[i]) + landDuration[i];
            minFinish = Math.min(minFinish, plan2);
        }

        return minFinish;
    }
}