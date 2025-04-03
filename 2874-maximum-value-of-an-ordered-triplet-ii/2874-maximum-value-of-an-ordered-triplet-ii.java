class Solution {
    public long maximumTripletValue(int[] nums) {
        int len = nums.length;
        int[] lmax = new int[len];
        int[] rmax = new int[len];

        int currLmax = nums[0];
        int currRmax = nums[len - 1];
        for (int i = 1; i < len - 1; i++) {
            lmax[i] = currLmax;
            currLmax = Math.max(currLmax, nums[i]);

            rmax[len - 1 - i] = currRmax;
            currRmax = Math.max(currRmax, nums[len - 1 - i]);
        }

        long ans = 0;
        for (int i = 1; i < len - 1; i++) {
            ans = Math.max(ans, 1L * (lmax[i] - nums[i]) * rmax[i]);
        }
        
        return ans;
    }
}