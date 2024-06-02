class Solution {
public:
    void reverseString(vector<char>& s) {
        int n = s.size();
        for (int beg = 0, end = n - 1; beg < end; beg++, end--) {
            char front = s[beg];
            s[beg] = s[end];
            s[end] = front;
        }
        
    }
};