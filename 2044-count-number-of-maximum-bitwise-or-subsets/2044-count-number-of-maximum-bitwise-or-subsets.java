class Solution {
    
    public int countMaxOrSubsets(int[] nums) {
        int len = nums.length;
        int maxor = 0;
        for (int num : nums) {
            maxor = maxor | num;
        }

        int ans = rec(0, nums, 0, maxor);
        return ans;
    }

    private int rec(int idx, int[] nums, int curror, int maxor) {
        if (idx == nums.length) {
            if (curror == maxor) {
                return 1;
            }

            return 0;
        }

        return rec(idx + 1, nums, curror | nums[idx], maxor) + rec(idx + 1, nums, curror, maxor);
    }
}