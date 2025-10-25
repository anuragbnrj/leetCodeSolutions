class Solution {
    public int totalMoney(int n) {
        int toPut = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 1) {
                toPut = (i / 7) + 1;

                ans += toPut;
            } else {
                toPut += 1;
                ans += toPut;
            }
        }

        return ans;
    }
}