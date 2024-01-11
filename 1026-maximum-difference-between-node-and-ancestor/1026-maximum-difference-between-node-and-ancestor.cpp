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
    int maxAncestorDiff(TreeNode* root) {
        int res = findDiff(root, root->val, root->val);
        return res;
    }

private:
    int findDiff(TreeNode* root, int mn, int mx) {
        int diffMn = abs(root->val - mn);
        int diffMx = abs(root->val - mx);

        mn = min(mn, root->val);
        mx = max(mx, root->val);

        int left = 0;
        int right = 0;

        if (root->left != nullptr) {
            left = findDiff(root->left, mn, mx);
        }

        if (root->right != nullptr) {
            right = findDiff(root->right, mn, mx);
        }

        return max({diffMn, diffMx, left, right});
    }
};