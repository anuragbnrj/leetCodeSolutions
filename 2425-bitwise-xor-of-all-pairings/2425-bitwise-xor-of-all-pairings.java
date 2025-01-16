class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int[] freq10 = new int[31];
        int[] freq11 = new int[31];
        for (int i = 0; i < len1; i++) {
            int curr = nums1[i];

            for(int bit = 0; bit < 31; bit++) {
                if ((curr & (1 << bit)) > 0) {
                    freq11[bit] += 1;
                } else {
                    freq10[bit] += 1;
                }
            }   
        }
        // System.out.println(Arrays.toString(freq10));
        // System.out.println(Arrays.toString(freq11));

        int len2 = nums2.length;
        int[] freq20 = new int[31];
        int[] freq21 = new int[31];
        for (int i = 0; i < len2; i++) {
            int curr = nums2[i];

            for (int bit = 0; bit < 31; bit++) {
                if ((curr & (1 << bit)) > 0) {
                    freq21[bit] += 1;
                } else {
                    freq20[bit] += 1;
                }
            }
        }
        // System.out.println(Arrays.toString(freq20));
        // System.out.println(Arrays.toString(freq21));

        int ans = 0;
        for (int i = 0; i < 31; i++) {
            long ones = (1L * freq10[i] * freq21[i]) + (1L * freq11[i] * freq20[i]);

            if (ones % 2 == 1) {
                ans = ans | (1 << i);
            }
        }

        return ans;
    }
}