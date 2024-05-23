class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;

        int[] left = new int[N + 2];
        left[0] = 1; left[N + 1] = 1;

        int[] right = new int[N + 2];
        right[0] = 1; right[N + 1] = 1;

        for (int i = 1; i <= N; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[N + 1 - i] = right[N + 1 - i + 1] * nums[N + 1 - i - 1];
        }
        
        int[] res = new int[N];
        for (int i = 1; i <= N; i++) {
            res[i - 1] = left[i - 1] * right[i + 1];
        }

        return res;
    }
}