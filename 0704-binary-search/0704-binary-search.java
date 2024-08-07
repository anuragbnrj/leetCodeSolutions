class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int beg = 0;
        int end = n;

        while (beg < end) {
            int mid = beg + ((end - beg) / 2);

            if (nums[mid] < target) beg = mid + 1;
            else end = mid;
        }

        if (beg == n) {
            return -1;
        }

        return (nums[beg] == target ? beg : -1);
        
    }
}