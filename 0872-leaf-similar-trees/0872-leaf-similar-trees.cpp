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
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> leaves1;
        vector<int> leaves2;

        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);

        if (leaves1 == leaves2) {
            return true;
        } else {
            return false;
        }
    }

private:
    void getLeaves(TreeNode* root, vector<int> &leaves) {
        // base case
        if (root->left == NULL && root->right == NULL) {
            leaves.push_back(root->val);
            return;
        }

        if (root->left != NULL) {
            getLeaves(root->left, leaves);
        }

        if (root->right != NULL) {
            getLeaves(root->right, leaves);
        }
    }
};