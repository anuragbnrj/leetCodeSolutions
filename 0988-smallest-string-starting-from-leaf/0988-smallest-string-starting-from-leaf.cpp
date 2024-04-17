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
    string ans = "";
public:
    string smallestFromLeaf(TreeNode* root) {
        string curr= "";
        solve(root, curr);

        return ans;
    }

private:
    void solve(TreeNode *root, string curr) {
        curr += ('a' + root->val);

        if (root->left == nullptr && root->right == nullptr) {    
            reverse(curr.begin(), curr.end());

            if (ans == "") {
                ans = curr;
            } else {
                if (curr < ans) {
                    ans = curr;
                }
            }
        }

        if (root->left != nullptr) {
            solve(root->left, curr);
        }

        if (root->right != nullptr) {
            solve(root->right, curr);
        }


    }
};