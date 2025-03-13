class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int qlen = queries.length;

        int beg = -1;
        int end = qlen;
        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (!isPossible(nums, queries, mid)) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }

        if (beg == qlen) {
            return -1;
        }

        return (beg + 1);
    }

    private boolean isPossible(int[] nums, int[][] queries, int mid) {
        // System.out.println("mid: " + mid);
        int[] temp = new int[nums.length + 1];

        // System.out.println("temp before queries: " + Arrays.toString(temp));
        for (int i = -1; i <= mid; i++) {
            if (i == -1) continue;
            int[] query = queries[i];
            int beg = query[0];
            int end = query[1];
            int val = query[2];

            temp[beg] -= val;
            temp[end + 1] += val;
        }
        // System.out.println("temp after queries: " + Arrays.toString(temp));


        int zCount = 0;
        for (int i = 0; i < nums.length; i++) {                
            if (i != 0) {
                temp[i] += temp[i - 1];
            }

            if (temp[i] + nums[i] <= 0) {
                zCount += 1;
            } 
        }
        // System.out.println("zCount: " + zCount);

        return zCount == nums.length;
    }
}