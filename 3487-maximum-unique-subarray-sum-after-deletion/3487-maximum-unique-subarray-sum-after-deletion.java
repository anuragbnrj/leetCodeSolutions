class Solution {
    public int maxSum(int[] nums) {
        int[] freq = new int[101];

        int ans = 0;
        int mx = -101;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            mx = Math.max(mx, curr); 
            if (curr >= 0 && freq[curr] == 0) {
                ans += curr;
                freq[curr] += 1;
            }
        }

        if (ans == 0) { return mx;}
        return ans;
    }
}