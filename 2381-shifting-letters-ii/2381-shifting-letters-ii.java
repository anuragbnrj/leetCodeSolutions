class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int len = s.length();
        int[] prefixSum = new int[len + 1];

        for (int i = 0; i < shifts.length; i++) {
            int beg = shifts[i][0];
            int end = shifts[i][1];
            int dir = shifts[i][2];

            if (dir == 1) {
                prefixSum[beg] += 1;
                prefixSum[end + 1] -= 1;
            } else {
                prefixSum[beg] -= 1;
                prefixSum[end + 1] += 1;
            }
        }

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i] + prefixSum[i - 1];
        }

        char[] temp = new char[len];
        for (int i = 0; i < len; i++) {
            int rot = ((prefixSum[i] % 26) + 26) % 26;
            
            temp[i] = (char) ('a' + ((((s.charAt(i) - 'a' + rot) % 26) + 26) % 26));
        }

        return new String(temp);
    }
}