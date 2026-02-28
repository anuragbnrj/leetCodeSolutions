class Solution {
    private static final long MOD = (int) 1e9 + 7;

    public int concatenatedBinary(int n) {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;

            List<Integer> binary = new ArrayList<>();
            while (num > 0) {
                int r = num % 2;
                if (r == 0) {
                    binary.add(0);
                } else {
                    binary.add(1);
                }

                num /= 2;
            }

            for (int j = binary.size() - 1; j >= 0; j--) {
                ans = (ans * 2L) % MOD;
                ans = (ans + binary.get(j)) % MOD;
            }
        }

        return (int) ans;
    }
}