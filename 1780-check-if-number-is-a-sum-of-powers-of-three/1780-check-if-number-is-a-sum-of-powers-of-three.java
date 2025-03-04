class Solution {
    public boolean checkPowersOfThree(int n) {
        int[] powers = new int[15];
        powers[0] = 1;
        for(int i = 1; i < 15; i++) {
            powers[i] = powers[i - 1] * 3;
        }
        
        Map<Pair<Integer, Integer>, Boolean> cache = new HashMap<>();
        return check(n, 0, powers, cache);
    }

    private boolean check(int n, int idx, int[] powers, Map<Pair<Integer, Integer>, Boolean> cache) {
        if (n == 0) {
            return true;
        } else if (n < 0) {
            return false;
        }

        if (idx >= 15) {
            return false;
        }

        Pair<Integer, Integer> key = new Pair<>(n, idx);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        boolean ans = false;
        // pick current index
        ans = ans | check(n - powers[idx], idx + 1, powers, cache);
        // leave current index
        ans = ans | check(n, idx + 1, powers, cache);

        cache.put(key, ans);

        return ans;
    }
}