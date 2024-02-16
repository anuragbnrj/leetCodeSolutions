class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        int len = arr.size();
        map<int, int> freq;
        for (int i = 0; i < len; i++) {
            freq[arr[i]] += 1;
        }

        multiset<int> stt;
        for (auto el : freq) {
            stt.insert(el.second);
        }

        int removed = 0;
        for (auto el : stt) {
            if (k - el < 0) {
                break;
            }

            k = k - el;
            removed++;
        }

        // cout << freq.size() - removed << endl;

        if (removed >= freq.size()) {
            return 0;
        } else {
            return freq.size() - removed;
        }
    }
};