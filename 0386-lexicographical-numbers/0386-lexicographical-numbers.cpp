bool cmp(const int &x, const int &y) { 
    return to_string(x) < to_string(y); 
}

class Solution {
public:
    vector<int> lexicalOrder(int n) {
        // string s = to_string(n);
        // int len = s.size();

        vector<int> arr;
        for (int i = 1; i <= n; i++) {
            arr.push_back(i);
        }

        sort(arr.begin(), arr.end(), cmp);

        return arr;
    }
};