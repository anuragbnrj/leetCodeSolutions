class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        int len = nums.size();
        long ans = 0;
        Map<Long, Long> freq = new HashMap<>();
        freq.put(0L, 1L);
        
        long count = 0; 
        for (int i = 0; i < len; i++) {
            if (nums.get(i) % mod == k) {
                count++;
            }
            
            long inv = (count - k) % mod;
            if (inv < 0) {
                inv += mod;
            }
            
            ans += freq.getOrDefault(inv, 0L);
            
            freq.put(count, freq.getOrDefault(count, 0L) + 1);
        }
        
        return ans;
    }
}
