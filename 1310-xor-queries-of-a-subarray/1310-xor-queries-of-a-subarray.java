class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;

        int[] pXor = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            pXor[i] = pXor[i - 1] ^ arr[i - 1];
        }

        int qLen = queries.length;
        int[] ans = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            int l = queries[i][0] + 1;
            int r = queries[i][1] + 1;

            ans[i] = pXor[r] ^ pXor[l - 1];
        }

        return ans;
    }
}