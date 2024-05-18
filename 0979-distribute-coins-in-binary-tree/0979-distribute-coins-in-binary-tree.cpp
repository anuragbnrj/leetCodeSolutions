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
    int totalMoves = 0;
    int distributeCoins(TreeNode* root) {
        distribute(root);

        return totalMoves;
    }

private:
    int distribute(TreeNode *root) {
        if (root == nullptr) {
            return 0;
        }

        int incoming = 0;
        int outgoing = 0;

        int left = distribute(root->left);
        int right = distribute(root->right);

        // cout << "---------------------------" << endl;
        // cout << "val: " << root->val << endl;
        // cout << "left: " << left << ", right: " << right << endl;

        if (left >= 0) {
            incoming += left;
        } else {
            outgoing += left;
        }

        if (right >= 0) {
            incoming += right;
        } else {
            outgoing += right;
        }

        totalMoves += (incoming + (abs(outgoing)));
        int selfReqd = root->val - 1;
        int res = incoming + (outgoing) + selfReqd;

        // cout << "incoming: " << incoming << ", outgoing: " << outgoing << endl;
        // cout << "totalMoves: " << totalMoves << endl;
        // cout << "return value: " << res << endl;
        // cout << "---------------------------" << endl;
        // cout << endl;

        return res;
    }
};