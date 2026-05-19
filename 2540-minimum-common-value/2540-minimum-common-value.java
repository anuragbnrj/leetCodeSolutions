class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int ans = -1;
        for (int i1 = 0, i2 = 0; i1 < nums1.length && i2 < nums2.length; ) {
            int n1 = nums1[i1];
            int n2 = nums2[i2];

            if (n1 == n2) {
                ans = n1;
                break;
            }

            if (n1 < n2) {
                i1 += 1;
            } else {
                i2 += 1;
            }
        }

        return ans;
    }
}