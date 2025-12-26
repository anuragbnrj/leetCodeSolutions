class Solution {
    public int bestClosingTime(String customers) {
        int len = customers.length();

        int[] noCus = new int[len];
        for (int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i);
            if (ch == 'N') {
                noCus[i] = 1;
            }

            if (i > 0) {
                noCus[i] += noCus[i - 1];
            }
        }

        int ans = len;
        int minPenalty = noCus[len - 1];
        int yesCus = 0;
        for (int i = len - 1; i >= 0; i--) {
            char ch = customers.charAt(i);

            if (ch == 'Y') {
                yesCus += 1;
            }
            int currPenalty = yesCus;
            
            if (i > 0) {
                currPenalty += noCus[i - 1];
            }

            if (currPenalty <= minPenalty) {
                minPenalty = currPenalty;
                ans = i;
            }
        }
        
        return ans;
    }
}