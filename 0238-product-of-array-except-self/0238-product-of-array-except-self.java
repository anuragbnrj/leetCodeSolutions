class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == 0) {
                zeroCount += 1;
            } else {
                product *= num;
            }
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 1) {
                ans[i] = 0;
                continue;
            }

            if (nums[i] == 0) {
                ans[i] = product;
            } else {
                if (zeroCount == 1) {
                    ans[i] = 0;
                } else {
                    ans[i] = product / nums[i];
                }
            }
        }

        return ans;
    }
}