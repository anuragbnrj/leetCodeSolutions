class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int len = dominoes.length;

        Map<String, Integer> freq = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int[] domino = dominoes[i];
            int mn = Math.min(domino[0], domino[1]);
            int mx = Math.max(domino[0], domino[1]);

            String uniqueKey = Integer.toString(mn) + "-" + Integer.toString(mx);

            int existingFreq = freq.getOrDefault(uniqueKey, 0);
            ans += existingFreq;

            freq.put(uniqueKey, existingFreq + 1);
        }
        
        return ans;
    }
}