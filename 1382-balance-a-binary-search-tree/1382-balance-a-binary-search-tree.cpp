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
    vector<int> arr;
    TreeNode* balanceBST(TreeNode* root) {
        arr.clear();
        generateArr(root);

        int n = arr.size();
        TreeNode *newRoot = generateBalancedBST(0, n - 1, arr);

        return newRoot;
    }

private:
    TreeNode* generateBalancedBST(int l, int r, vector<int> &arr) {
        if (l > r) {
            return nullptr;
        }

        int mid = l + (r - l) / 2;

        TreeNode *left = generateBalancedBST(l, mid - 1, arr);
        TreeNode *right = generateBalancedBST(mid + 1, r, arr);

        TreeNode *curr = new TreeNode(arr[mid]);
        curr->left = left;
        curr->right = right;

        return curr;
    }

    void generateArr(TreeNode *root) {
        if (root == nullptr) {
            return;
        }

        generateArr(root->left);
        arr.push_back(root->val);
        generateArr(root->right);
    }
};