class DisjointSet {
private:
    vector<int> rank, parent, size;

public:
    DisjointSet(int n) {
        rank.resize(n + 1, 0);
        parent.resize(n + 1);
        size.resize(n + 1, 1);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    int findUltimateParent(int node) {
        if (parent[node] == node) {
            return node;
        }

        return parent[node] = findUltimateParent(parent[node]);
    }

    void unionByRank(int u, int v) {
        int pU = findUltimateParent(u);
        int pV = findUltimateParent(v);
        if (pU == pV) {
            return;
        }

        if (rank[pU] == rank[pV]) {
            pU = pV;
            rank[pV]++;
        } else if (rank[pU] <= rank[pV]) {
            parent[pU] = pV;
        } else {
           parent[pV] = pU;
        }
    }

    void unionBySize(int u, int v) {
        int pU = findUltimateParent(u);
        int pV = findUltimateParent(v);
        if (pU == pV) {
            return;
        }

        if (size[pU] == size[pV]) {
            parent[pU] = pV;
            size[pV] += size[pU];
        } else if (size[pU] < size[pV]) {
            parent[pU] = pV;
            size[pV] += size[pU];
        } else {
            parent[pV] = pU;
            size[pU] += size[pV];
        }
    }

    int findDistinctParents(int n) {
        for (int i = 0; i < n; i++) {
            cout << i + 1 << ": " << parent[i] + 1 << endl;
        }
        set<int> parents;
        for (int i = 0; i < n; i++) {
            int parent = findUltimateParent(i);
            parents.insert(parent);
        }

        for (int i = 0; i < n; i++) {
            cout << i + 1 << ": " << parent[i] + 1 << endl;
        }

        return parents.size();
    }

};

class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        if (connections.size() < n - 1) {
            return -1;
        }

        DisjointSet ds(n);
        for (int i = 0; i < (int) connections.size(); i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            ds.unionBySize(a, b);
        }

        int connected = ds.findDistinctParents(n);

        return (connected - 1);
    }
};