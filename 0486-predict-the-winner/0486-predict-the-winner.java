class Solution {
    public boolean predictTheWinner(int[] nums) {
        int size = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int player1Score = maxPossibleScore(0, size - 1, nums);
        int player2Score = sum - player1Score;

        return player1Score >= player2Score;
    }

    private int maxPossibleScore(int l, int r, int[] nums) {
        if (l > r) return 0;

        // pick left
        int score1 = nums[l] + Math.min(maxPossibleScore(l + 2, r, nums), maxPossibleScore(l + 1, r - 1, nums));

        // pick right
        int score2 = nums[r] + Math.min(maxPossibleScore(l + 1, r - 1, nums), maxPossibleScore(l, r - 2, nums));

        return Math.max(score1, score2);
    }
}