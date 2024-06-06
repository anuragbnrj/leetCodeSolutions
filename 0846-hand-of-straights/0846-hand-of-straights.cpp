class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        int n = hand.size();
        if (n % groupSize != 0) {
            return false;
        }

        sort(hand.begin(), hand.end());
        reverse(hand.begin(), hand.end());

        multiset<pair<int, int>> top;
        for (int i = 0; i < n; i++) {
            int el = hand[i];

            auto it = top.upper_bound({el, 1e5});
            if (it == top.end() || it->first != (el + 1)) {
                if (groupSize > 1) {
                    top.insert({el, groupSize});
                }  
            } else {
                if (it->second >= 3) {
                    int order = it->second;
                    top.erase(it);
                    top.insert({el, order - 1});
                } else {
                    top.erase(it);
                }
            }
        }

        // for (auto el : top) {
        //     cout << "{" << el.first << ", " << el.second << "} ";
        // }
        // cout << endl;

        if (top.size() > 0) {
            cout << top.size() << endl;
            return false;
        }
 
        return true;
    }
};