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
    int findBottomLeftValue(TreeNode* root) {
        int height = findHeight(root);

        cout << "height: " << height << endl;

        TreeNode* res = findBottomLeft(root, height - 1);

        return res->val;
    }
private:
    int findHeight(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }

        int height = 1 + max(findHeight(root->left), findHeight(root->right));

        return height;
    }

    TreeNode* findBottomLeft(TreeNode* root, int depth) {
        if (root == nullptr) {
            return nullptr;
        }

        cout << "val: " << root->val << " depth: " << depth << endl;

        if (depth == 0) {
            return root;
        }

        TreeNode* res = findBottomLeft(root->left, depth - 1);

        if (res != nullptr) {
            return res;
        }

        return findBottomLeft(root->right, depth - 1);
    }
};