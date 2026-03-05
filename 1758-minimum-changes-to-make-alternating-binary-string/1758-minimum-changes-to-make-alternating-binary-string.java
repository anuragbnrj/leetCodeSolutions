class Solution {
    public int minOperations(String s) {
        int len = s.length();

        int[] num1 = createAlternatingString(len, 0);
        int[] num2 = createAlternatingString(len, 1);
        int diff1 = 0;
        int diff2 = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            int digit = ch - '0';

            if (digit != num1[i]) diff1 += 1;

            if (digit != num2[i]) diff2 += 1;
        }

        return Math.min(diff1, diff2);
    }

    private int[] createAlternatingString(int len, int startDigit) {
        int[] numStr = new int[len];

        for (int i = 0; i < len; i++) {
            numStr[i] = startDigit;

            startDigit = 1 - startDigit;
        }

        return numStr;
    }
}