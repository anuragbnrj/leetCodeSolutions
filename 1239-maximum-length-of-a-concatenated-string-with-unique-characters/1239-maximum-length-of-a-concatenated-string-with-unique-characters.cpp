class Solution {
public:
    int maxLength(vector<string>& arr) {
        int len = arr.size();
        int res = INT_MIN;

        for (long long i = 0; i < (1 << len); i++) {
            string temp;
            vector<bool> occur(26, 0);
            bool unique = true;
            for (int j = 0; j < len; j++) {
                if ((i >> j) & 1) {
                    for (char ch : arr[j]) {
                        if (occur[ch - 'a']) {
                            unique = false;
                            break;
                        } else {
                            temp += ch;
                            occur[ch - 'a'] = true;
                        }
                    }
                }
            }

            if (unique) {
                res = max(res, (int)temp.size());
            }

              
        }
        
        return res;
    }

};