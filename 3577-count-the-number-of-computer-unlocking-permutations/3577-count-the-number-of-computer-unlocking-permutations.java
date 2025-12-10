class Solution {
    private final long MOD = (long) 1E9 + 7;

    public int countPermutations(int[] complexity) {
        int len = complexity.length;

        int zeroComplexity = complexity[0];
        int minComplexity = complexity[0];
        int minComplexityFreq = 1;
        for (int i = 1; i < len; i++) {
            int curr = complexity[i];
            if (curr < minComplexity) {
                minComplexity = complexity[i];
            } else if (curr == minComplexity) {
                return 0;
            }
        }

        if (zeroComplexity != minComplexity) {
            return 0;
        }

        long ans = 1;
        for (int i = 2; i <= len - 1; i++) {
            ans = (ans * i) % MOD;
        }
        
        return (int) ans;
    }
}