class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBits1 = Integer.bitCount(num1);
        int setBits2 = Integer.bitCount(num2);

        if (setBits1 < setBits2) {
            int res = 0;
            setBits2 -= setBits1;
            for (int bit = 0; bit < 31 && setBits2 > 0; bit++) {
                if ((num1 & (1 << bit)) == 0) {
                    res = res | (1 << bit);
                    setBits2 -= 1;
                }
            }

            return res | num1;
        } else if (setBits1 == setBits2) {
            return num1;
        } else {
            int res = 0;
            for (int bit = 30; bit >= 0 && setBits2 > 0; bit--) {
                if ((num1 & (1 << bit)) > 0) {
                    res = res | (1 << bit);
                    setBits2 -= 1;
                }
            }

            return res;
        }
    }
}