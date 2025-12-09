class Solution {
    private final long MOD = (long) 1e9 + 7;
    public int specialTriplets(int[] nums) {
        int len = nums.length;
        long ans = 0L;
        long[] freq = new long[200005];
        long[] freqAsMid = new long[200005];
        for (int i = 0; i < len; i++) {
            int num = nums[i];

            if (num % 2 == 0) {
                ans = (ans + freqAsMid[num / 2]) % MOD;
            }

            freqAsMid[num] = (freqAsMid[num] + freq[num * 2]) % MOD;
            freq[num] = (freq[num] + 1) % MOD;
        }
        
        return (int) ans;
    }
}