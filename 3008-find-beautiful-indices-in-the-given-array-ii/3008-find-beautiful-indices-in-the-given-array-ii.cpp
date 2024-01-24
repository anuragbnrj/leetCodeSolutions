class Solution {
public:
    vector<int> beautifulIndices(string s, string a, string b, int k) {
        vector<int> aMatchIndices = KMPSearch(s, a);
        vector<int> bMatchIndices = KMPSearch(s, b);

        vector<int> res;
        for (int i = 0; i < (int)aMatchIndices.size(); i++) {
            int idx1 = lower_bound(bMatchIndices.begin(), bMatchIndices.end(), aMatchIndices[i] - k) - bMatchIndices.begin();
            if (idx1 != bMatchIndices.size()) {
                if (abs(bMatchIndices[idx1] - aMatchIndices[i]) <= k) {
                    res.push_back(aMatchIndices[i]);
                    continue;
                }
            }

            int idx2 = lower_bound(bMatchIndices.begin(), bMatchIndices.end(), aMatchIndices[i] + k) - bMatchIndices.begin();
            if (idx2 != bMatchIndices.size()) {
                if (abs(bMatchIndices[idx2] - aMatchIndices[i]) <= k) {
                    res.push_back(aMatchIndices[i]);
                    continue;
                }
            }
        }

        return res;
    }

private:
    void computeLPSArray(string pat, vector<int> &lps) {
        int m = pat.size();
        // length of the previous longest prefix suffix
        int len = 0;
    
        lps[0] = 0; // lps[0] is always 0
    
        // the loop calculates lps[i] for i = 1 to M-1
        int i = 1;
        while (i < m) {
            if (pat[i] == pat[len]) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];
    
                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    vector<int> KMPSearch(string &txt, string &pat)
    {
        int n = txt.size();
        int m = pat.size();

        vector<int> matchingIndices;
    
        // create lps[] that will hold the longest prefix suffix
        // values for pattern
        vector<int> lps(m);
    
        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pat, lps);
    
        int i = 0; // index for txt[]
        int j = 0; // index for pat[]
        while ((n - i) >= (m - j)) {
            if (pat[j] == txt[i]) {
                j++;
                i++;
            }
    
            if (j == m) {
                // cout << "Found pattern at: " << (i - j) << endl;
                matchingIndices.push_back(i - j);
                j = lps[j - 1];
            }
    
            // mismatch after j matches
            else if (i < n && pat[j] != txt[i]) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }

        return matchingIndices;
    }
};