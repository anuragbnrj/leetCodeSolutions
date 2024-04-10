class Solution {
public:
    vector<int> deckRevealedIncreasing(vector<int>& deck) {
        int n = deck.size();
        sort(deck.begin(), deck.end());

        deque<int> dq;

        for (int i = n - 1; i >= 0; i--) {
            if (dq.size() > 0) {
                int back = dq.back();
                dq.pop_back();
                dq.push_front(back);
            }

            dq.push_front(deck[i]);
        }

        vector<int> res;
        while (dq.size() > 0) {
            int front = dq.front();
            dq.pop_front();
            res.push_back(front);
        }

        return res;
    }
};