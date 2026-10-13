class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) nums[i] *= -1;
        }
        Arrays.sort(nums);
        
        long ans = 0L;
        for (int l = 0, r = nums.length - 1; l <= r; l++, r--) {
            ans += 1L * nums[r] * nums[r];

            if (l != r) {
                ans -= 1L * nums[l] * nums[l];
            }
        }
        
        return ans;
    }
}