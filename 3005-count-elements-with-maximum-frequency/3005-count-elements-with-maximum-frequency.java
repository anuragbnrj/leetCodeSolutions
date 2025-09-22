class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];

        int maxFreq = 0;
        for (int num : nums) {
            freq[num] += 1;

            maxFreq = Math.max(maxFreq, freq[num]);
        }

        int numMaxFreq = 0;
        for (int i = 1; i <= 100; i++) {
            if (freq[i] == maxFreq) {
                numMaxFreq += 1;
            }
        }

        return maxFreq * numMaxFreq;
    }
}