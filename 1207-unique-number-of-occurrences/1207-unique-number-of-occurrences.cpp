class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        int n = arr.size();
        map<int, int> mpp;

        for (int i = 0; i < n; i++) {
            mpp[arr[i]]++;
        }

        bool res = true;
        set<int> occurrences;
        for (auto el : mpp) {
            if (occurrences.count(el.second)) {
                res = false;
                break;
            } else {
                occurrences.insert(el.second);
            }
        }

        return res;
        
    }
};