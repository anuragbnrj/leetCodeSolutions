class Solution {
    public int maxScore(String s) {
        int len = s.length();

        int totalZeros = 0;
        int totalOnes = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (ch == '0') {
                totalZeros += 1;
            } else {
                totalOnes += 1;
            }
        }

        int onesFromBeg = 0;
        int zerosFromBeg = 0;
        int maxScore = -1;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (ch == '0') {
                zerosFromBeg += 1;
            } else {
                onesFromBeg += 1;
            }

            int score = zerosFromBeg + (totalOnes - onesFromBeg);

            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}