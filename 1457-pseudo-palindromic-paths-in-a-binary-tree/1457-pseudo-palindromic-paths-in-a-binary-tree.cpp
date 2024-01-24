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
    int pseudoPalindromicPaths (TreeNode* root) {
        vector<int> freq(10, 0);
        return solve(root, freq);
    }

private:
    int solve(TreeNode* root, vector<int> &freq) {
        if (root->left == nullptr && root->right == nullptr) {
            freq[root->val]++;
            int oddCount = 0;
            for (int i = 0; i < (int)freq.size(); i++) {
                if (freq[i] % 2 == 1) {
                    oddCount++;
                }
            }
            freq[root->val]--;
            

            if (oddCount > 1) {
                return 0;
            } else {
                return 1;
            }
        }

        int val = root->val;
        freq[val]++;
        int res = 0;

        if (root->left != nullptr) {
            res += solve(root->left, freq);
        }

        if (root->right != nullptr) {
            res += solve(root->right, freq);
        }

        freq[val]--;
        return res;
    }
};