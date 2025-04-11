class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) {
                ans += 1;
            }
        }

        return ans;
    }

    private boolean isSymmetric(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            int r = num % 10;
            num /= 10;
            digits.add(r);
        }

        if (digits.size() % 2 == 1) return false;

        int lsum = 0, rsum = 0;
        for (int i = 0; i < digits.size() / 2; i++) {
            lsum += digits.get(i);
            rsum += digits.get(digits.size() - 1 - i);
        }

        return (lsum == rsum);
    }
}