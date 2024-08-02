class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int ones = 0;
        int[] arr = new int[2 * n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
            arr[n + i] = nums[i];

            if (nums[i] == 1) {
                ones += 1;
            }
        }

        int longest = 0;
        int zeroCount = 0;
        int oneCount = 0;
        int ans = 1_000_000_000;
        for (int beg = 0, end = 0; end < (2 * n); end++) {
            if (arr[end] == 1) {
                oneCount += 1;
            } else {
                zeroCount += 1;
            }

            if ((end - beg + 1) == ones) {
                ans = Math.min(ans, ones - oneCount);

                if (arr[beg] == 1) {
                    oneCount -= 1;
                } else {
                    zeroCount -= 1;
                }
                beg += 1;
            }
        }

        if (ans == 1_000_000_000) {
            return 0;
        }

        return ans;   
    }
}