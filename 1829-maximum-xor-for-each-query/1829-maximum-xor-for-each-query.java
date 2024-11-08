class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int len = nums.length;
        
        int xorr = 0;
        for (int i = 0; i < len; i++) {
            xorr = xorr ^ nums[i];
        }

        int[] ans = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int k = 0; 
            for (int bit = 0; bit < maximumBit; bit++) {
                if ((xorr & (1 << bit)) == 0) {
                    k = k | (1 << bit);
                }
            }
            xorr = xorr ^ nums[i];

            ans[len - 1 - i] = k;
        }

        return ans;   
    }
}