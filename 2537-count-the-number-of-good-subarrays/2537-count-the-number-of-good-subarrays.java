class Solution {
    public long countGood(int[] nums, int k) {
        int len = nums.length;

        int left = 0;
        int right = -1;
        int pairs = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        long ans = 0;
        while (left < len) {
            while (right + 1 < len && pairs < k) {
                right += 1;
                int curr = nums[right];

                int existingFreq = freq.getOrDefault(curr, 0);
                pairs += existingFreq;
                freq.put(curr, existingFreq + 1);
            }

            if (pairs >= k) {
                ans += (len - right);
            }

            if (left <= right) {
                int leftEl = nums[left];

                int existingFreq = freq.get(leftEl);
                pairs -= (existingFreq - 1);
                freq.put(leftEl, existingFreq - 1);

                left += 1;
            } else {
                left += 1;
                right = left - 1;
            }

        } 
        
        return ans;
    }
}