class Solution {
    public int smallestRepunitDivByK(int k) {
        int currLen = 1;
        long currNum = 1L;
        for (; currLen <= 20005; currLen++) {
            if (currNum % k == 0) {
                return currLen;
            }

            currNum = (currNum * 10 + 1) % k;
        }

        return -1;
    }
}