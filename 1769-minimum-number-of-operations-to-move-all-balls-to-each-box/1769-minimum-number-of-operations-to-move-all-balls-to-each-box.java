class Solution {
    public int[] minOperations(String boxes) {
        int len = boxes.length();

        int[] fromBeg = new int[len];
        int currSum = boxes.charAt(0) == '1' ? 1 : 0;
        for(int i = 1; i < len; i++) {
            fromBeg[i] = fromBeg[i - 1] + currSum;

            if (boxes.charAt(i) == '1') {
                currSum += 1;
            }
        }

        int[] fromEnd = new int[len];
        currSum = boxes.charAt(len - 1) == '1' ? 1 : 0;
        for (int i = len - 2; i >= 0; i--) {
            fromEnd[i] = fromEnd[i + 1] + currSum;

            if (boxes.charAt(i) == '1') {
                currSum += 1;
            }
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] += fromBeg[i] + fromEnd[i];
        }

        return ans;
    }
}