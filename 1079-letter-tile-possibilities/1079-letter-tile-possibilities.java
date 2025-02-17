class Solution {
    private int ans;
    private Set<String> occurred;

    public int numTilePossibilities(String tiles) {
        ans = 0;
        occurred = new HashSet<>();

        int[] freq = new int[26];
        rec(0, tiles, freq);

        return ans;
    }

    private void rec(int idx, String tiles, int[] freq) {
        if (idx == tiles.length()) {
            int num = 0;
            int den = 1;

            StringBuilder mask = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    num += freq[i];

                    den *= getFactorial(freq[i]);
                }
                mask.append(freq[i]);
                mask.append(":");
            }

            String maskStr = mask.toString();
            if (num > 0 && !occurred.contains(maskStr)) {
                num = getFactorial(num);
                ans += (num / den);

                occurred.add(maskStr);
            }
            
            return;
        }

        // pick
        int curr = tiles.charAt(idx) - 'A';
        freq[curr] += 1;
        rec(idx + 1, tiles, freq);
        
        // not pick
        freq[curr] -= 1;
        rec(idx + 1, tiles, freq);
    }

    private int getFactorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }
}