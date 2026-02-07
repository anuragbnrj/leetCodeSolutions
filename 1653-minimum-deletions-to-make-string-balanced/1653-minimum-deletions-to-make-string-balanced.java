class Solution {
    public int minimumDeletions(String s) {
        int len = s.length();
        
        int[] aEnd = new int[len + 1];
        int[] bEnd = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                aEnd[i] = aEnd[i + 1] + 1;
                bEnd[i] = bEnd[i + 1];
            } else {
                aEnd[i] = aEnd[i + 1];
                bEnd[i] = bEnd[i + 1] + 1;
            }
        }

        int aBeg = 0;
        int bBeg = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int deletions = bBeg + aEnd[i + 1];
            ans = Math.min(ans, deletions);

            if (s.charAt(i) == 'a') {
                aBeg += 1;
            } else {
                bBeg += 1;
            }
        }

        return ans;
    }
}