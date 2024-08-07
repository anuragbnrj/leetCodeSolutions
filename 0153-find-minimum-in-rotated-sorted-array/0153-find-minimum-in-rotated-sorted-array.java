class Solution {
    public int findMin(int[] nums) {
        int beg = 0;
        int end = nums.length;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (nums[mid] < nums[0]) end = mid;
            else beg = mid + 1;
        }

        if (beg == nums.length) return nums[0];
        
        return nums[beg];
    }
}