class Solution {
    public int maxOperations(String s) {
        int len = s.length();

        int ans = 0;
        int zeroSeriesTillNow = 0;
        for (int i = len - 1; i >= 0; ) {
            int j = i;
            while (j >= 0 && s.charAt(j) == '0') {
                j--;
            }
            if (j != i) zeroSeriesTillNow += 1;

            i = j;
            if (i >= 0 && s.charAt(i) == '1') {
                ans += zeroSeriesTillNow;
            }
            i -= 1;
        }

        return ans;
    }
}