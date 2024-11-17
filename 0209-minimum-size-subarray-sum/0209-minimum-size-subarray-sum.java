class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int len = nums.length;

        int ans = (int) 1e9;
        int currSum = 0;
        
        int left = 0;
        int right = -1;

        while (left < len) {
            while (right + 1 < len && currSum < k) {
                right += 1;
                currSum += nums[right];
            }
            System.out.println("left: " + left + ", right: " + right + ", currSum: " + currSum);

            if (currSum >= k) {
                ans = Math.min(ans, right - left + 1);
            }

            if (left <= right) {
                currSum -= nums[left];
                left += 1;
            } else {
                left += 1;
                right = left - 1;
            }
        }


        return (ans == (int) 1e9) ? 0 : ans;
    }
}