class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;

        int currStart = (int) -1e5;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] - currStart > k) {
                ans += 1;
                currStart = nums[i];
            }
        }

        return ans;
    }
}