class Solution {
    public int minimumOperations(int[] nums) {
        int len = nums.length;

        int[] freq = new int[101];
        for (int num : nums) {
            freq[num] += 1;
        }

        int ops = 0;
        boolean containsUnique = false;
        for (int i = 0; i < len; i += 3) {
            for (int j = i; j < len && j < (i + 3); j++) {
                int curr = nums[j];
                if (freq[curr] > 1) {
                    ops = Math.max(ops, (i/3) + 1);
                }
                freq[curr] -= 1;
            }
        }

        return ops;
    }
}