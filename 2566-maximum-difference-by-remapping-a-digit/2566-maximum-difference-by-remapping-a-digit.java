class Solution {
    public int minMaxDifference(int num) {
        String numStr = Integer.toString(num);

        int maxNum = 0;
        char msdNotNine = numStr.charAt(0);
        if (msdNotNine == '9') {
            for (int i = 0; i < numStr.length(); i++) {
                char ch = numStr.charAt(i);

                if (ch != '9') {
                    msdNotNine = ch;
                    break;
                }
            }
        }
        for (int i = 0; i < numStr.length(); i++) {
            char curr = numStr.charAt(i);

            if (curr == msdNotNine) {
                maxNum = maxNum * 10 + 9;
            } else {
                maxNum = maxNum * 10 + (int)(curr - '0');
            }
        }

        char msd = numStr.charAt(0);
        int minNum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            char curr = numStr.charAt(i);

             if (curr == msd) {
                minNum = minNum * 10;
            } else {
                minNum = minNum * 10 + (int)(curr - '0');
            }

        }

        return maxNum - minNum;
    }
}