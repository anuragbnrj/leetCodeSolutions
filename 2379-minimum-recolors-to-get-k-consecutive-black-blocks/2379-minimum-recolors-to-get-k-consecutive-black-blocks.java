class Solution {
    public int minimumRecolors(String blocks, int k) {
        int len = blocks.length();
        int[] whiteCount = new int[len];

        int ans = Integer.MAX_VALUE;
        int currWhiteCount = 0;
        for (int i = 0; i < len; i++) {
            char ch = blocks.charAt(i);
            if (ch == 'W') {
                currWhiteCount += 1;
            }
            whiteCount[i] = currWhiteCount;
            
            if (i == (k - 1)) {
                ans = Math.min(ans, whiteCount[i]);
            } else if (i > k - 1) {
                int opsReqd = whiteCount[i] - whiteCount[i - k];
                ans = Math.min(ans, opsReqd);
            }
        }

        return ans;
    }
}