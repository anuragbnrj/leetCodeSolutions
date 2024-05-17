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
    TreeNode* removeLeafNodes(TreeNode* root, int target) {
        deleteLeafNodes(root, target);
    }

private:
    TreeNode* deleteLeafNodes(TreeNode *root, int target) {
        if (root == nullptr) {
            return;
        }

        

        root->left = deleteLeafNodes(root->left, target);
        root->right = deleteLeafNodes(root->right, target);

        

        if (root->left != nullptr && root->left->left == nullptr && root->left->right == nullptr && root->left->val == target) {
            root->left = nullptr;
        }

        if (root->right != nullptr && root->right->left == nullptr && root->right->right == nullptr && root->right->val == target) {
            root->right = nullptr;
        }

        return;
    }
};