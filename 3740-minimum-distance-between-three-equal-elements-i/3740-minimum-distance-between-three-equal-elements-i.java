class Solution {
    public int minimumDistance(int[] nums) {
        int ans = 1_000_000_000;

        int[] prevOccur = new int[101];
        Arrays.fill(prevOccur, -1);

        int[] prevPrevOccur = new int[101];
        Arrays.fill(prevPrevOccur, -1);


        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (prevPrevOccur[num] == -1 && prevOccur[num] == -1) {
                prevOccur[num] = i;
            } else if (prevPrevOccur[num] == -1 && prevOccur[num] != -1) {
                prevPrevOccur[num] = prevOccur[num];
                prevOccur[num] = i;
            } else {
                ans = Math.min(ans, (i - prevPrevOccur[num]) + (i - prevOccur[num]) + (prevOccur[num] - prevPrevOccur[num]));

                prevPrevOccur[num] = prevOccur[num];
                prevOccur[num] = i;
            }
        }

        return (ans == 1_000_000_000) ? -1 : ans;
    }
}