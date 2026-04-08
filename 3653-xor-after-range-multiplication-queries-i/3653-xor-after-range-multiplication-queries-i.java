class Solution {
    private final long MOD = (long) 1e9 + 7;


    public int xorAfterQueries(int[] nums, int[][] queries) {

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            for (int i = l; i <= r; i+= k) {
                long temp = (1L * nums[i] * v) % MOD;

                nums[i] = (int) temp;
            }
        }


        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }
}