class Solution {
    public int numRabbits(int[] answers) {
        int[] freq = new int[1001];

        for (int ans : answers) {
            freq[ans] += 1;
        }

        int ans = 0;
        for (int i = 0; i < 1001; i++) {
            ans += (freq[i] / (i + 1)) * (i + 1);

            if (freq[i] % (i + 1) != 0) {
                ans += (i + 1);
            }
        }

        return ans;
    }
}