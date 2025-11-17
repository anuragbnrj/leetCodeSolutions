class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1 * (k + 1);
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            
            if (curr == 1) {
                if (i - prev <= k) return false;

                prev = i;
            }
        }

        return true;
    }
}