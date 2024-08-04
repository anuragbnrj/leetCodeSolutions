class Solution {
    int MOD = (int) 1e9 + 7;
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Long> subarraySums = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < n; i++) {
            long currSum = 0L;
            for (int j = 0; (i + j) < n; j++) {
                currSum = (currSum + nums[i + j] % MOD);

                subarraySums.add(currSum);
            }
        }
        
        Collections.sort(subarraySums);

        long ans = 0;
        for (int i = left - 1; i < right; i++) {
            ans = (ans + subarraySums.get(i)) % MOD; 
        }

        return (int)ans;
    }
}