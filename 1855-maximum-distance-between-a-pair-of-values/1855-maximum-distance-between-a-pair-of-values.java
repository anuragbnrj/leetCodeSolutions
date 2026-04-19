class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        // int ans = -1;
        // while (i < nums1.length && j < nums2.length) {
        //     int x = nums1[i];
        //     int y = nums2[j];

        //     while (x == y && j < nums2.length) {
        //         y = nums2[j];

        //         ans = Math.max(ans, j - i);
        //         j += 1;
        //     } ;

        //     if (x < y) {
        //         j += 1;
        //     } else {
        //         i += 1;
        //     }
        // }
        
        // return ans;

        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];

            int upBound = upperBound(nums2, num);

            ans = Math.max(ans, upBound - 1 - i);
        }

        return ans;
    }

    private int upperBound(int[] arr, int src) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= src) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}