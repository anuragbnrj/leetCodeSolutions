class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        
        for (int inc = start, dec = start - 1; dec >= 0 || inc < nums.length; dec--, inc++) {
            if (inc < nums.length) {
                if (nums[inc] == target) {
                    return Math.abs(inc - start);
                }
            }

            if (dec >= 0) {
                if (nums[dec] == target) {
                    return Math.abs(start - dec);
                }
            }
        }
        
        return start;
    }
}