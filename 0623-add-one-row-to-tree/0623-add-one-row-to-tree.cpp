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
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        if (depth == 1) {
            TreeNode *temp = new TreeNode;
            temp->val = val;
            temp->left = root;
            root = temp;
        } else {
            solve(root, 1, depth, val);
        }

        return root;
    }

private:
    void solve(TreeNode *root, int currDepth, int depth, int val) {
        if (currDepth > (depth - 1)) {
            return;
        } else if (currDepth == (depth - 1)) {
            TreeNode *left = new TreeNode;
            left->val = val;
            left->left = root->left;
            root->left = left;

            TreeNode *right = new TreeNode;
            right->val = val;
            right->right = root->right;
            root->right = right;

            return;
        } else {
            if (root->left != nullptr) {
                solve(root->left, currDepth + 1, depth, val);
            }

            if (root->right != nullptr) {
                solve(root->right, currDepth + 1, depth, val);
            }
        }

    }
};