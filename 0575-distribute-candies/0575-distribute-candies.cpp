class Solution {
public:
    int distributeCandies(vector<int>& candyType) {
        int len = candyType.size();
        unordered_set<int> eaten;

        int ctr = 0;
        for (int i = 0; i < len && ctr < len / 2; i++) {
            if (!eaten.count(candyType[i])) {
                ctr++;
                eaten.insert(candyType[i]);
            } 
        }

        return ctr;
        
    }
};