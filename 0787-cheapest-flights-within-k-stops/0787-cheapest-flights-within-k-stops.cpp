class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<vector<pair<int, int>>> graph(n);
        for (int i = 0; i < (int)flights.size(); i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];

            graph[u].push_back({v, w});
        }
        
        int allowedLevels = k + 2;
        
        vector<int> minDist(n, INT_MAX);
        queue<pair<int, int>> q;
        q.push({src, 0});
        minDist[src] = 0;

        int currLevel = 1;
        while (!q.empty() && currLevel <= allowedLevels) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                auto front = q.front();
                q.pop();

                int currNode = front.first;
                int currDist = front.second;

                if (currDist < minDist[currNode]) {
                    minDist[currNode] = currDist;
                }

                for (auto edge : graph[currNode]) {
                    int v = edge.first;
                    int w = edge.second;

                    if (currDist + w < minDist[v]) {
                        q.push({v, currDist + w});
                    } 

                }
            }

            currLevel++;
        }


        if (minDist[dst] == INT_MAX) {
            return -1;
        }

        return minDist[dst];
    }
};