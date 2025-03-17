class Solution {
    public boolean divideArray(int[] nums) {
        int xorr = 0;
        for (int num : nums) {
            xorr = xorr ^ num;
        }

        return (xorr == 0);
    }
}