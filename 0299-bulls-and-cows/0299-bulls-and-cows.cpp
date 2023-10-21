class Solution {
public:
    string getHint(string secret, string guess) {
        int len = secret.size();

        vector<int> countSecret(10, 0);
        vector<int> countGuess(10, 0);

        int bulls = 0;
        for (int i = 0; i < len; i++) {
            if (secret[i] == guess[i]) {
                bulls += 1;
            } else {
                                
                countSecret[secret[i] - '0'] += 1;
                countGuess[guess[i] - '0'] += 1;
            }
        }

        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += min(countSecret[i], countGuess[i]);
        }

        string res = "";
        res.append(to_string(bulls));
        res.append("A");
        res.append(to_string(cows));
        res.append("B");


        return res;
    }
};