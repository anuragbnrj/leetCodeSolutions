class Solution {
    public int binaryGap(int n) {
        int prevIdx = -1;
        int currIdx = 0;

        int ans = 0;
        while (n > 0) {
            int r = n % 2;
            if (r == 1) {
                if (prevIdx != -1) {
                    ans = Math.max(ans, currIdx - prevIdx);
                }

                prevIdx = currIdx;
            }

            n /= 2;
            currIdx += 1;
        }

        return ans;
    }
}