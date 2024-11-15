class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        int left = 0, right = len - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right -= 1;
        }

        int ans = right;
        while (left < right && (left == 0 || arr[left - 1] <= arr[left])) {
            while (right < len && arr[left] > arr[right]) {
                right += 1;
            }

            ans = Math.min(ans, right - left - 1);
            left += 1;
        }

        return (ans == (int) 1e9) ? 0 : ans;
    }
}