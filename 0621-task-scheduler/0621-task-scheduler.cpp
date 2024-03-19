class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int len = tasks.size();

        map<char, int> freq;
        for (int i = 0; i < len; i++) {
            char ch = tasks[i];
            freq[ch]++;
        }

        priority_queue<pair<int, char>> pq;
        map<char, int> lastUsed;
        for (auto el : freq) {
            char ch = el.first;
            int count = el.second;
            pq.push({count, ch});
            lastUsed[ch] = -200;
        }

        int currTime = 1;
        while (pq.size() > 0) {
            vector<pair<int, char>> temp;

            while (pq.size() > 0 && (currTime - lastUsed[pq.top().second]) <= n) {
                auto top = pq.top();
                pq.pop();
                temp.push_back(top);
            }

            if (pq.size() > 0) {
                auto top = pq.top();
                pq.pop();
                int count = top.first;
                char ch = top.second;
                lastUsed[ch] = currTime;
                
                count--;
                if (count > 0) {
                    pq.push({count, ch});
                }
            }

            while (temp.size() > 0) {
                auto back = temp.back();
                temp.pop_back();
                pq.push(back);
            }

            currTime++;
        }
        
        return currTime - 1;
        
    }
};