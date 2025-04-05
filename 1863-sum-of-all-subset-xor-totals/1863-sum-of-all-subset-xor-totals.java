class Solution {
    public int subsetXORSum(int[] nums) {
        int len = nums.length;

        int ans = 0;
        for (int i = 0; i < (1 << len); i++) {
            int currXor = 0;
            for (int bit = 0; bit < len; bit++) {
                if ((i & (1 << bit)) > 0) {
                    currXor = currXor ^ nums[bit];
                }
            }

            ans += currXor;
        }

        return ans;
    }
}