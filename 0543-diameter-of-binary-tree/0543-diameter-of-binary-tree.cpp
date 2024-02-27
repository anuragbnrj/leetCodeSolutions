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
    int diameter = INT_MIN;

    int diameterOfBinaryTree(TreeNode* root) {
        int diameter = 0;
        calculateHeight(root, diameter);
        return diameter;
    }

private:
    int calculateHeight(TreeNode* root, int &diameter) {
        if (root == nullptr) {
            return 0;
        }

        int heightLeft = calculateHeight(root->left, diameter);
        int heightRight = calculateHeight(root->right, diameter);

        diameter = max(diameter, heightLeft + heightRight);

        int currHeight = 1 + max(heightLeft, heightRight);

        return currHeight;
    }
};