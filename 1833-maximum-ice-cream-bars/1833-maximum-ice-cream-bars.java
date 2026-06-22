class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] freq = new int[100005];

        for (int cost : costs) {
            freq[cost] += 1;
        }
        
        int bars = 0;
        for (int i = 1; i < 100005 && coins > 0; i++) {
            if (freq[i] == 0) continue;

            int possible = coins / i;
            if (possible < freq[i]) {
                coins = 0;
            } else {
                possible = freq[i];
                coins = coins - (i * freq[i]);
            }

            bars += possible;
        }

        return bars;
    }
}