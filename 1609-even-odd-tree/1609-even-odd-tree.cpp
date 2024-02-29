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
    bool isEvenOddTree(TreeNode* root) {
        bool res = true;
        bool isEvenLevel = true;
        int prev;

        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty() && res) {
            int sz = q.size();

            if (isEvenLevel) {
                prev = INT_MIN;
            } else {
                prev = INT_MAX;
            }

            while (sz-- && res) {
                TreeNode* front = q.front();
                int val = front->val;
                q.pop();

                if (isEvenLevel) {
                    if (val <= prev || (val % 2) == 0) {
                        res = false;
                        break;
                    }
                } else {
                    if (val >= prev || (val % 2) == 1) {
                        res = false;
                        break;
                    }
                }

                TreeNode* left = front->left;
                if (left != nullptr) {
                    q.push(left);
                }

                TreeNode* right = front->right;
                if (right != nullptr) {
                    q.push(right);
                }

                prev = val;
            }

            isEvenLevel = !isEvenLevel;
        }
        

        return res;
    }
};