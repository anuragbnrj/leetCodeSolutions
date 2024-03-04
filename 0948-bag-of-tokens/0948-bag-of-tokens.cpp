class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        int len = tokens.size();

        sort(tokens.begin(), tokens.end());
        vector<int> psum(len);

        bool possible = true;
        int beg = 0;
        int end = len - 1;
        int maxScore = 0;
        int currScore = 0;
        int currPower = power;
        
        while (possible && beg <= end) {
            if (currPower < tokens[beg] && currScore == 0) {
                possible = false;
            }

            while (beg <= end && currPower >= tokens[beg]) {
                currPower -= tokens[beg];
                beg++;
                currScore++;
                // cout << currScore << endl;
                maxScore = max(maxScore, currScore);
            }

            if (beg <= end && currScore > 0) {
                currPower += tokens[end];
                end--;
                currScore--;
                
            }
        }

        return maxScore;
        
    }
};