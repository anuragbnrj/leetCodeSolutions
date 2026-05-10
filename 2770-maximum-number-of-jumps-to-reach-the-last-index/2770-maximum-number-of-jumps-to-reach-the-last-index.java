class Solution {
    public int maximumJumps(int[] nums, int target) {
        int size = nums.length;

        int[] cache = new int[size];
        cache[size - 1] = 0;
        for (int i = size - 2; i >= 0; i--) {
            int maxJumpsFrom = -1;
            for (int j = i + 1; j < size; j++) {
                if (cache[j] == -1) {
                    continue;
                }

                if (Math.abs(nums[j] - nums[i]) <= target) {
                    
                    maxJumpsFrom = Math.max(maxJumpsFrom, cache[j] + 1);
                }
            }

            cache[i] = maxJumpsFrom;
        }

        return cache[0];
    }
}