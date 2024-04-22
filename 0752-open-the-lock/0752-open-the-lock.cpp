class Solution {
public:
    
    int openLock(vector<string>& deadends, string target) {
        set<string> dead(deadends.begin(), deadends.end());

        string curr = "0000";
        if (dead.find(curr) != dead.end()) {
            return -1;
        }

        queue<string> q;
        q.push(curr);
        set<string> visited;
        visited.insert(curr);

        int level = 0;
        for ( ;!q.empty(); level++) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                string front = q.front();
                q.pop();

                if (front == target) {
                    return level;
                }

                string curr = front;
                for (int idx = 0; idx < 4; idx++) {
                    int digit = curr[idx] - '0';

                    int next = (digit + 1) % 10;
                    curr[idx] = next + '0';
                    if (dead.find(curr) == dead.end() && visited.find(curr) == visited.end()) {
                        q.push(curr);
                        visited.insert(curr);
                    }

                    int prev = (((digit - 1) % 10) + 10) % 10;
                    curr[idx] = prev + '0';
                    if (dead.find(curr) == dead.end() && visited.find(curr) == visited.end()) {
                        q.push(curr);
                        visited.insert(curr);
                    }

                    curr[idx] = digit + '0';
                }
            }
        }

        return -1;
    }
};
