/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        vector<vector<int>> graph(501);
        constructGraph(root, graph);

        vector<bool> visited(501, false);
        vector<int> res;
        dfs(target->val, k, graph, visited, res);

        return res;
    }

private:
    void dfs(int src, int k, vector<vector<int>>& graph, vector<bool> visited,
             vector<int>& res) {
        visited[src] = true;

        if (k == 0) {
            res.push_back(src);
            return;
        }

        for (int el : graph[src]) {
            if (!visited[el]) {
                dfs(el, k - 1, graph, visited, res);
            }
        }
    }

    void constructGraph(TreeNode* root, vector<vector<int>>& graph) {
        if (root->left != nullptr) {
            int n1 = root->val;
            int n2 = root->left->val;
            addUndirectedEdge(n1, n2, graph);
            constructGraph(root->left, graph);
        }

        if (root->right != nullptr) {
            int n1 = root->val;
            int n2 = root->right->val;
            addUndirectedEdge(n1, n2, graph);
            constructGraph(root->right, graph);
        }
    }

    void addUndirectedEdge(int n1, int n2, vector<vector<int>>& graph) {
        graph[n1].push_back(n2);
        graph[n2].push_back(n1);
    }
};