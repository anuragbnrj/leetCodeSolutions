class Solution {
    public int minOperations(int[] nums, int k) {
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num] += 1;
        }

        int gr = 0;
        int ls = 0;
        for (int i = 1; i <= 100; i++) {
            if (freq[i] > 0) {
                if (i > k) gr += 1;
                if (i < k) ls += 1;
            }
        }

        if (ls > 0) return -1;

        return gr;
    }
}