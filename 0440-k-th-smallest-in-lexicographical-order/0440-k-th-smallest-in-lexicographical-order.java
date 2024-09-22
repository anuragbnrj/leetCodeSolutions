class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k -= 1;

        while (k > 0) {
            int step = countSteps(n, curr, curr + 1);

            if (step <= k) {
                curr += 1;
                k -= step;
            } else {
                curr *= 10;
                k -= 1;
            }
        }

        return curr;
    }

    private int countSteps(int n, long beg, long end) {
        int steps = 0;

        while (beg <= n) {
            steps += Math.min(n + 1, end) - beg;
            beg *= 10;
            end *= 10;
        }

        return steps;
    }
}