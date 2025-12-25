class Solution {
    public long maximumHappinessSum(int[] h, int k) {
        int n = h.length;
        Arrays.sort(h);

        long res = 0L;
        for (int i = 0, idx = n - 1; i < k; i++, idx--) {
            res += Math.max(0, h[idx] - i);
        }
        
        return res;
    }
}