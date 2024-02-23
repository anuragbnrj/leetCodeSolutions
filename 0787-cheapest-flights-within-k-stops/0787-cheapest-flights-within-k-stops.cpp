class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        int levelsAllowed = k + 2;

        vector<vector<pair<int, int>>> graph(n);
        for (int i = 0; i < (int)flights.size(); i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];

            graph[u].push_back({v, w});
        }
        
        vector<int> minDist(n, INT_MAX);
        vector<int> visited(n, 0);
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>> > pq;
        queue<vector<int>> q;
        pq.push({1, 0, src});
        visited[src] = 1;
        
        while (!pq.empty()) {
            int sz = pq.size();
            for (int i = 0; i < sz; i++) {
                auto top = pq.top();
                pq.pop();
                int currLevel = top[0];
                int currDist = top[1];
                int currNode = top[2];

                if (currDist < minDist[currNode]) {
                    minDist[currNode] = currDist;
                }

                for (auto next : graph[currNode]) {
                    int nextLevel = currLevel + 1;
                    int nextDist = next.second;
                    int nextNode = next.first;

                    cout << currNode << "\t" << nextNode << "\t" << nextLevel << endl;
                    
                    if (nextLevel <= levelsAllowed && currDist + nextDist < minDist[nextNode]) {
                        pq.push({nextLevel, currDist + nextDist, nextNode});
                    }
                }
            }
        }

        if (minDist[dst] == INT_MAX) {
            return -1;
        }

        return minDist[dst];
    }
};