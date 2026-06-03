class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        int sizeLand = landStartTime.length;
        int sizeWater = waterStartTime.length;

        int earliestFinishLand = Integer.MAX_VALUE;
        for (int i = 0; i < sizeLand; i++) {
            earliestFinishLand = Math.min(earliestFinishLand, landStartTime[i] + landDuration[i]);
        }
        for (int i = 0; i < sizeWater; i++) {
            ans = Math.min(ans, Math.max(earliestFinishLand, waterStartTime[i]) + waterDuration[i]);
        }
        
        int earliestFinishWater = Integer.MAX_VALUE;
        for (int i = 0; i < sizeWater; i++) {
            earliestFinishWater = Math.min(earliestFinishWater, waterStartTime[i] + waterDuration[i]);
        }
        for (int i = 0; i < sizeLand; i++) {
            ans = Math.min(ans, Math.max(earliestFinishWater, landStartTime[i]) + landDuration[i]);
        }
        
        return ans;
    }
}