class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;

        long currSum = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        while (right < k - 1) {
            int curr = nums[right];
            currSum += curr;
            int count = freq.getOrDefault(curr, 0);
            freq.put(curr, count + 1);
            right += 1;
        }

        long ans = 0;
        for ( ; right < len; right++, left++) {
            int curr = nums[right];
            currSum += curr;
            int count = freq.getOrDefault(curr, 0);
            freq.put(curr, count + 1);

            if (freq.size() == k) {
                ans = Math.max(ans, currSum);
            }

            int windowBeg = nums[left];
            currSum -= windowBeg;
            count = freq.get(windowBeg);
            freq.put(windowBeg, count - 1);
            if ((count - 1) == 0) {
                freq.remove(windowBeg);
            }
        }   

        return ans;
    }
}