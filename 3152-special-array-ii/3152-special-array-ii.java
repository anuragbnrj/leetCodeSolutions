class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] = nums[i] % 2;
        }

        int[] prefixSum = new int[len + 1];
        prefixSum[0] = 0;
        prefixSum[1] = 1;
        for (int i = 2; i <= len; i++) {
            if (nums[i - 1] != nums[i - 2]) {
                prefixSum[i] = prefixSum[i - 1] + 1;
            } else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }

        // System.out.println(Arrays.toString(prefixSum));

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int beg = query[0] + 1;
            int end = query[1] + 1;
            if (beg == end) {
                ans[i] = true;
                continue;
            }

            int sum = prefixSum[end] - prefixSum[beg];
            if (sum == (end - beg)) {
                ans[i] = true;
            }
        }

        return ans;
    }
}