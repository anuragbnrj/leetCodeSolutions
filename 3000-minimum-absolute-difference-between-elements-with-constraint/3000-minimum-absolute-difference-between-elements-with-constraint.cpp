class Solution {
public:
    int minAbsoluteDifference(vector<int>& nums, int x) {
        int len = nums.size();
        
        set<int> stt;
        int res = INT_MAX;
        for (int i = x; i < len; i++) {
            int curr = nums[i];
            stt.insert(nums[i - x]);
            
            auto lb = stt.lower_bound(curr);
            
            if (lb == stt.begin()) {
                // cout << "begin: " << *lb << "\t" << curr << endl; 
                res = min(res, abs(*lb - curr));
            } else if (lb == stt.end()) {
                auto prevPtr = --lb;
                // cout << "end: " << curr << "\t" << *prevPtr << endl; 
                res = min(res, abs(curr - *prevPtr));
            } else {
                // cout << "mid: " << *lb << "\t" << curr << "\t" << *prevPtr << endl;
                res = min(res, abs(*lb - curr));
                auto prevPtr = --lb;
                res = min(res, abs(curr - *prevPtr));
            }
        }


        return res;
    }
    
};