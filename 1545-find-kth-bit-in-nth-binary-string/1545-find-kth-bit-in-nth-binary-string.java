class Solution {
    public char findKthBit(int n, int k) {
        int idx = 1;
        String currStr = "0";

        while (idx < n) {
            currStr = currStr + "1" + reverse(invert(currStr));
            idx += 1;
        }

        return currStr.charAt(k - 1);
    }

    private String invert(String str) {
        char[] strArr = str.toCharArray();

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == '1') {
                strArr[i] = '0';
            } else {
                strArr[i] = '1';
            }
        }

        return new String(strArr);
    }

    private String reverse(String str) {
        char[] strArr = str.toCharArray();
        int len = strArr.length;

        for (int beg = 0, end = len - 1; beg < end; beg += 1, end -= 1) {
            char temp = strArr[beg];
            strArr[beg] = strArr[end];
            strArr[end] = temp;
        }

        return new String(strArr);
    }
}