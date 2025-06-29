class Solution {
    private final int MOD = (int) 1e9 + 7;
    
    public int numSubseq(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        
        long[] power2 = new long[len];
        power2[0] = 1;
        for (int i = 1; i < len; i++) {
            power2[i] = (power2[i - 1] * 2) % MOD;
        }
        
        int left = 0, right = len - 1;
        long ans = 0;
        
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                ans = (ans + power2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }
        
        return (int) ans;
    }
}