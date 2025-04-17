class Solution {
    public int countPairs(int[] nums, int k) {
        int len = nums.length;
        int[] freq = new int[101];
        
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j] && ((i * j) % k) == 0) {
                    ans += 1;
                }
            }
        }
        
        return ans;
    }
}