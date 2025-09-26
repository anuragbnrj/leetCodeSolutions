class Solution {
    public int triangleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            int beg = 0;
            int end = i - 1;

            while (beg < end) {
                if (nums[beg] + nums[end] > nums[i]) {
                    ans += (end - beg);
                    end -= 1;
                } else {
                    beg += 1;
                }
            }
        }

        return ans;
    }
}