/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    int amountOfTime(TreeNode* root, int start) {
        vector<vector<int>> graph(1e5 + 1);

        convertToGraph(root, graph);
        vector<int> visited(1e5 + 1, -1);
        dfs(start, visited, graph, 0);

        int res = INT_MIN;
        for (int el : visited) {
            res = max(res, el);
        }

        return res;
    }

private:
    void dfs(int node, vector<int> &visited, vector<vector<int>>& graph, int depth) {
        visited[node] = depth;

        for (int el : graph[node]) {
            if (visited[el] == -1) {
                dfs(el, visited, graph, depth + 1);
            }
        }
    }

    void addUndirectedEdge(int n1, int n2, vector<vector<int>>& graph) {
        graph[n1].push_back(n2);
        graph[n2].push_back(n1);
    }

    void convertToGraph(TreeNode* root, vector<vector<int>>& graph) {
        // base case
        if (root->left == NULL && root->right == NULL) {
            return;
        }

        // recursive case
        if (root->left != NULL) {
            addUndirectedEdge(root->val, root->left->val, graph);
            convertToGraph(root->left, graph);
        }

        if (root->right != NULL) {
            addUndirectedEdge(root->val, root->right->val, graph);
            convertToGraph(root->right, graph);
        }
    }
};