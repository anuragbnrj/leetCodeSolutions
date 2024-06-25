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
    TreeNode* bstToGst(TreeNode* root) {
        constructGreaterTree(root, 0);

        return root;
    }

    int constructGreaterTree(TreeNode *root, int fromParent) {
        if (root == nullptr) {
            return 0;
        }

        int initialVal = root->val;
        
        int fromRight = constructGreaterTree(root->right, fromParent + 0);
        
        int fromLeft = constructGreaterTree(root->left, fromParent + fromRight + initialVal);

        // cout << "root->val: " << initialVal << ", fromParent: " << fromParent << ", fromRight: " << fromRight << ", fromLeft: " << fromLeft << endl;

        root->val = initialVal + fromRight + fromParent;

        return fromLeft + fromRight + initialVal;
    }
};