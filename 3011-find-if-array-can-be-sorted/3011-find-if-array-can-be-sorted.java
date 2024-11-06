class Solution {
    public boolean canSortArray(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    if (Integer.bitCount(nums[j]) != Integer.bitCount(nums[j + 1])) {
                        return false;
                    } else {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }

        return true;
    }
}