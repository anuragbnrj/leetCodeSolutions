class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (nums[i] != (nums.length - 1)) return false;
            } else {
                if (nums[i] != (i + 1)) return false;
            }
        }

        return true;
    }
}