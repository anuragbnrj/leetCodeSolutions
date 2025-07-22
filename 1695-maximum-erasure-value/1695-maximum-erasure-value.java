class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;

        int left = 0, right = -1;
        Map<Integer, Integer> freq = new HashMap<>();
        int ans = 0;
        int currSum = 0;
        while (left < len) {
            while (right + 1 < len && freq.getOrDefault(nums[right + 1], 0) == 0) {
                right += 1;
                freq.put(nums[right], 1);
                currSum += nums[right];
                ans = Math.max(ans, currSum);
            }

            if (left <= right) {
                int curr = nums[left];
                currSum -= curr;
                freq.put(curr, freq.get(curr) - 1);
                left += 1;   
            } else {
                left += 1;
                right = left - 1;
            }
        }
        
        return ans;
    }
}