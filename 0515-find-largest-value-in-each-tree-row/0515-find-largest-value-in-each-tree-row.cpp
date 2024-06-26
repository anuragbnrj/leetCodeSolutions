/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        vector<int> res;

        queue<TreeNode *> q;
        if (root) {
            q.push(root);
        }
        
        while (!q.empty()) {
            int sz = q.size();
            int levelMx = INT_MIN;
            for (int i = 0; i < sz; i++) {
                TreeNode *front = q.front();
                q.pop();
                int val = front->val;
                
                levelMx = max(levelMx, val);

                if (front->left) q.push(front->left);
                if (front->right) q.push(front->right);
            }

            res.push_back(levelMx);
        }

        return res;
    }
};