class Solution {
public:
    int distributeCandies(vector<int>& candyType) {
        int len = candyType.size();

        unordered_set<int> eaten;
        for (int i = 0; i < len; i++) {
            eaten.insert(candyType[i]);
        }

        return min((int) eaten.size(), (len / 2));
    }
};