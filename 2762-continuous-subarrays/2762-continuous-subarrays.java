class Solution {
    public long continuousSubarrays(int[] nums) {
        int len = nums.length;

        long ans = 0;
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int left = 0, right = 0; right < len; right++) {
            int curr = nums[right];  
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);

            while (left <= right && (Math.abs(freq.firstKey() - curr) > 2 || Math.abs(freq.lastKey() - curr) > 2)) {
                int leftElement = nums[left];
                freq.put(leftElement, freq.get(leftElement) - 1);

                if (freq.get(leftElement) == 0) {
                    freq.remove(leftElement);
                }

                left += 1;
            }

            ans += right - left + 1;
        }
        
        return ans;
    }
}