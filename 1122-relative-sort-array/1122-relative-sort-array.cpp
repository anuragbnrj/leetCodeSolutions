class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        vector<int> freq(1001, 0);

        for (int i = 0; i < arr1.size(); i++) {
            int num = arr1[i];
            freq[num] += 1;
        }

        vector<int> res;
        for (int i = 0; i < arr2.size(); i++) {
            int num = arr2[i];
            for (int j = 0; j < freq[num]; j++) {
                res.push_back(num); 
            }
            freq[num] = 0;
        }

        for (int i = 0; i < 1001; i++) {
            int num = i;
            if (freq[i] != 0) {
                for (int j = 0; j < freq[num]; j++) {
                    res.push_back(num);
                }
            }
        }

        return res;
    }
};