class Solution {
    public long minimumSteps(String s) {
        int len = s.length();
        int[] suffixZeroes = new int[len + 1];

        int zeroCount = 0;
        long ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            suffixZeroes[i] = zeroCount;

            if (ch == '0') {
                zeroCount += 1;
            } else {
                ans += suffixZeroes[i];
            }
        }

        return ans;
    }
}