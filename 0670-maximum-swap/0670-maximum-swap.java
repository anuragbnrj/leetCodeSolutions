class Solution {
    public int maximumSwap(int num) {
        char[] numArr = Integer.toString(num).toCharArray();

        int len = numArr.length;
        char mx = numArr[len - 1];
        int mxIdx = len - 1;
        int[] mxIdxExcludingCurr = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            char ch = numArr[i];
            mxIdxExcludingCurr[i] = mxIdx;

            if (ch > mx) {
                mx = ch;
                mxIdx = i;
            }
        }

        for (int i = 0; i < len; i++) {
            char curr = numArr[i];
            // System.out.println(numArr[i] + ", " + mxIdxExcludingCurr[i]);
            if (numArr[mxIdxExcludingCurr[i]] > curr) {
                char temp = curr;
                numArr[i] = numArr[mxIdxExcludingCurr[i]];
                numArr[mxIdxExcludingCurr[i]] = temp;
                break;
            }
        }


        return Integer.parseInt(new String(numArr));
        
    }
}