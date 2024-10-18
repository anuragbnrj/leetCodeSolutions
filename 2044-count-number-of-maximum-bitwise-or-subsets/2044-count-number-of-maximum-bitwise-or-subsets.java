class Solution {

    public int countMaxOrSubsets(int[] nums) {
        int len = 3 * (int) 1e5 + 1;
        int[] freq = new int[len];

        rec(0, nums, freq, 0);

        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (freq[i] > 0) {
                ans = freq[i];
                break;
            }
        }

        return ans;
    }

    private void rec(int idx, int[] nums, int[] freq, int currOr) {
        if (idx >= nums.length) {
            // System.out.println("idx: " + idx + ", currXor: " + currOr);
            freq[currOr] += 1;
            return;
        }

        // pick
        rec(idx + 1, nums, freq, (currOr | nums[idx]));

        // not pick
        rec(idx + 1, nums, freq, currOr);
    }
}