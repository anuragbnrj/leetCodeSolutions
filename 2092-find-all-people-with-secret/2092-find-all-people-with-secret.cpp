#pragma GCC optimize("O3", "unroll-loops")
class Solution {
public:
    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        int len = meetings.size();
        vector<vector<pair<int, int>>> graph(n);
        for (int i = 0; i < len; i++) {
            int u = meetings[i][0];
            int v = meetings[i][1];
            int wt = meetings[i][2];

            graph[u].push_back({v, wt});
            graph[v].push_back({u, wt});
        }

        graph[0].push_back({firstPerson, 0});
        graph[firstPerson].push_back({0, 0});

        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>> > pq;
        pq.push({0, 0});

        vector<bool> hasSecret(n, false);
        vector<bool> visited(n, false);
        while (!pq.empty()) {
            auto top = pq.top();
            pq.pop();
            int curr = top.second;
            int currTime = top.first;

            if (visited[curr]) {
                continue;
            }

            visited[curr] = true;
            hasSecret[curr] = true;

            for (auto el : graph[curr]) {
                int neighbour = el.first;
                int time = el.second;
                
                
                if (!visited[neighbour] && currTime <= time) {
                    // cout<< curr << "\t" << neighbour << "\t" << time << endl;
                    pq.push({time, neighbour});
                }
            }
        }

        vector<int> res;
        for (int i = 0; i < n; i++) {
            if (hasSecret[i]) {
                res.push_back(i);
            }
        }

        return res;
    }
};
