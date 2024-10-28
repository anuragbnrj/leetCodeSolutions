class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        Map<Long, Integer> streakStartingAt = new HashMap<>();
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            long curr = nums[i];
            long sq = curr * curr;

            if (streakStartingAt.containsKey(sq)) {
                int val = streakStartingAt.get(sq) + 1;
                streakStartingAt.put(curr, val);
            } else {
                streakStartingAt.put(curr, 1);
            }

            ans = Math.max(ans, streakStartingAt.get(curr));
        }

        return ans == 1 ? -1 : ans;
    }
}