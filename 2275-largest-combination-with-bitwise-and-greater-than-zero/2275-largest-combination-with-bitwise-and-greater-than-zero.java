class Solution {
    public int largestCombination(int[] candidates) {
        int len = candidates.length;

        int ans = 0;
        for (int bit = 0; bit < 31; bit += 1) {
            int bitOneCount = 0;
            for (int i = 0; i < len; i += 1) {
                int num = candidates[i];

                if (((num >> bit) & 1) == 1) {
                    bitOneCount += 1;
                }
            }

            // System.out.println("bit: " + bit + ", bitOneCount: " + bitOneCount);
            ans = Math.max(ans, bitOneCount);
        }

        return ans;
    }
}