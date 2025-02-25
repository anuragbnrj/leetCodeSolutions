class Solution {
    private int MOD = (int) 1e9 + 7;

    public int numOfSubarrays(int[] arr) {
        long evenSum = 1;
        long oddSum = 0;

        long currSum = 0;
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            currSum += curr;

            if (currSum % 2 == 0) {
                ans = (ans + oddSum) % MOD;
                evenSum += 1;
            } else {
                ans = (ans + evenSum) % MOD;
                oddSum += 1;
            }
        }

        return(int) ans;
    }
}