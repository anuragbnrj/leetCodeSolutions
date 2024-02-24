class Solution {
public:
    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        int len = meetings.size();
        sort(meetings.begin(), meetings.end(), cmp);

        initializeDsu(n);
        unionByRank(0, firstPerson);
        for (int i = 0; i < len; ) {
            int currTime = meetings[i][2];
            
            unordered_set<int> currNodes;
            while (i < len && meetings[i][2] == currTime) {
                int u = meetings[i][0];
                int v = meetings[i][1];
                unionByRank(u, v);
                
                currNodes.insert(u);
                currNodes.insert(v);

                i++;
            }
            

            for (const auto &node : currNodes) {
                if (findParent(node) != findParent(0)) {
                    resetParent(node);
                }
            }
        }

        vector<int> res;
        for (int i = 0; i < n; i++) {
            if (findParent(i) == findParent(0)) {
                res.push_back(i);
            }
        }

        return res;
    }

private:
    vector<int> parent, rank;

    void initializeDsu(int n) {
        rank.resize(n + 1, 0);
        parent.resize(n + 1);
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
    }

    int findParent(int node) {
        if (parent[node] == node) {
            return parent[node];
        }

        return parent[node] = findParent(parent[node]);
    }

    void unionByRank(int x, int y) {
        int parX = findParent(x);
        int parY = findParent(y);

        if (parX == parY) {
            return;
        }

        if (rank[parX] == rank[parY]) {
            parent[parX] = parY;
            rank[parY]++;
        } else if (rank[parX] < rank[parY]) {
            parent[parX] = parY;
        } else {
            parent[parY] = parX;
        }
    }

    void resetParent(int node) {
        parent[node] = node;
    }

    static bool cmp(const vector<int> &x, const vector<int> &y) {
        if (x[2] == y[2]) {
            return x[0] < y[0];
        } else {
            return x[2] < y[2];
        }
    }
};