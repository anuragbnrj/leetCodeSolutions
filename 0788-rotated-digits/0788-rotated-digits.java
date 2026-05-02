class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                ans += 1;
            }
        }
        
        return ans;
    }

    private boolean isGood(int num) {
        int temp = num;
        int regenNum = 0;

        int multiplier = 1;
        while (temp > 0) {
            int r = temp % 10;
            temp /= 10;

            if (r == 3 || r == 4 || r == 7) {
                return false;
            } else if (r == 1 || r == 3 || r == 8) {
                regenNum += multiplier * r;
            } else if (r == 2) {
                regenNum += multiplier * 5;
            } else if (r == 5) {
                regenNum += multiplier * 2;
            } else if (r == 6) {
                regenNum += multiplier * 9;
            } else if (r == 9) {
                regenNum += multiplier * 6;
            }

            multiplier *= 10;
        }

        System.out.println("num: " + num + ", regenNum: " + regenNum);
        if (num == regenNum) {
            return false;
        }

        return true;
    }
}