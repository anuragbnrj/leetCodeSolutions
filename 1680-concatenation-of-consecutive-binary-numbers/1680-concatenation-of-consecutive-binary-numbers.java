class Solution {
    private static final long MOD = (int) 1e9 + 7;

    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            concatenateBinary(sb, i);
        }

        long ans = 0;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            ans = (ans * 2L) % MOD;
            ans = (ans + (ch - '0')) % MOD;
        }

        return (int) ans;
    }

    private void concatenateBinary(StringBuilder sb, int num) {
        StringBuilder temp = new StringBuilder();
        while (num > 0) {
            int r = num % 2;
            if (r == 0) {
                temp.append('0');
            } else {
                temp.append('1');
            }

            num /= 2;
        }

        temp.reverse();
        sb.append(temp);
    }
}