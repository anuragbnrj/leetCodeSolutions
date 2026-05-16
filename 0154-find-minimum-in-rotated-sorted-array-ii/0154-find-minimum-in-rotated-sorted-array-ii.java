class Solution {
    public int findMin(int[] nums) {
        int beg = 0;
        int end = nums.length - 1;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (nums[mid] > nums[end]) beg = mid + 1;
            else if (nums[mid] == nums[end]) end -= 1;
            else end = mid;
        }

        if (beg == nums.length) return nums[0];
        
        return nums[beg];
    }
}