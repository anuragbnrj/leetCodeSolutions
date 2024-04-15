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
    int sumNumbers(TreeNode* root) {
        return solve(root, 0);
    }

private:
    int solve(TreeNode* root, int fromParent) {
        int carryAhead = fromParent * 10 + root->val;
        
        if (root->left == nullptr && root->right == nullptr) {
            return carryAhead;
        }

        int sum = 0;
        if (root->left != nullptr) {
            sum += solve(root->left, carryAhead);
        }
        if (root->right != nullptr) {
            sum += solve(root->right, carryAhead);
        }
        
        return sum;
    }
};