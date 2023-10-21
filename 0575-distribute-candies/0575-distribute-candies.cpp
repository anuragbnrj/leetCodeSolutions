class Solution {
public:
    int distributeCandies(vector<int>& candyType) {
        int len = candyType.size();
        set<int> eaten;

        int ctr = 0;
        for (int i = 0; i < len && ctr < len / 2; i++) {
            if (eaten.count(candyType[i])) {

            } else {
                ctr++;
                eaten.insert(candyType[i]);
            }
        }

        return ctr;
        
    }
};