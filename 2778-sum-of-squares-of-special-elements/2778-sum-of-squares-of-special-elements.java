class Solution {
    public int sumOfSquares(int[] nums) {
        int size = nums.length;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            int curr = nums[i];
            if (size % (i + 1) == 0) {
                ans += (curr * curr);
            }
        }
        
        return ans;
    }
}