class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int len = nums.length;

        if (len <= 2) {
            return len;
        } else {
            int temp = len;

            int msb = 0;
            while (temp > 0) {
                msb += 1;
                temp = temp >> 1;
            }

            return (int) Math.pow(2, msb);
        }
        
    }
}