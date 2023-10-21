class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        int arrays = nums.size();

        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

        int maxVal = INT_MIN;
        vector<int> next(nums.size());  // To track the next element to be considered in each array

        for (int i = 0; i < arrays; i++) {
            pq.push({nums[i][0], i});
            maxVal = max(maxVal, nums[i][0]);
            next[i] = 1;  // Initialize to the next element in each array
        }

        vector<int> res = {-1000000000, 1000000000};  // Initialize with extreme values

        while (pq.size() == arrays) {
            auto top = pq.top();
            pq.pop();
            int num = top.first;
            int array = top.second;

            if (maxVal - num < res[1] - res[0]) {
                res = {num, maxVal};
            }

            if (next[array] < nums[array].size()) {
                int nextNum = nums[array][next[array]];
                pq.push({nextNum, array});
                maxVal = max(maxVal, nextNum);
                next[array]++;
            }
        }

        return res;
    }


    // vector<int> smallestRange(vector<vector<int>>& nums) {
    //     int arrays = nums.size();

    //     priority_queue< pair<int, int>, vector< pair<int, int> >, greater< pair<int,int> > > pq;

    //     for (int i = 0; i < arrays; i++) {
    //         for (int j = 0; j < nums[i].size(); j++) {
    //             pq.push({nums[i][j], i});
    //         }
    //     }


    //     vector<pair<int, int>> arr;
    //     while (pq.size() > 0) {
    //         auto top = pq.top();
    //         pq.pop();

    //         arr.push_back(top);
    //     }

    //     set<pair<int, int>> included;
    //     set<int> contains;
    //     vector<int> res = {-100000000, 100000000};
    //     for (int i = 0; i < arr.size(); i++) {
    //         int num = arr[i].first;
    //         int array = arr[i].second;

    //         if (contains.count(array)) {
    //             auto it = included.begin();

    //             while (it != included.end() && it->second != array) {
    //                 pair<int, int> temp = *it;
    //                 int array = temp.second;
    //                 included.erase(it);
    //                 contains.erase(array);
    //             }
    //         }

    //         included.insert(arr[i]);
    //         contains.insert(array);

    //         // if (contains.size() == arrays) {
    //         //     auto temp = *(included.begin());
    //         //     int min = temp.first;

    //         //     auto it = included.end();
    //         //     it--;
    //         //     temp = *it;
    //         //     int max = temp.first;

    //         //     if (max - min < res[1] - res[0]) {
    //         //         res = {min, max};
    //         //     } else if (max - min == res[1] - res[0]) {
    //         //         if (min < res[0]) {
    //         //             res = {min, max};
    //         //         }
    //         //     }
    //         // } 
                
    //     }

    //     return res;
    // }
};