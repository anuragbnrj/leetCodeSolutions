/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeNodes(ListNode* head) {
        vector<int> values;

        solve(head, 0, values);

        ListNode *newHead = nullptr;
        ListNode *prev = nullptr;
        for(int i = 0; i < values.size(); i++) {
            ListNode *temp = new ListNode(values[i]);

            if (newHead == nullptr) {
                newHead = temp;
            } else {
                prev->next = temp;
            }

            prev = temp;
        }

        return newHead;
    }

private:
    void solve(ListNode* head, int currSum, vector<int> &values) {
        if (head == nullptr) {
            return;
        }

        if (head->val == 0) {
            if (currSum != 0) {
                values.push_back(currSum);
            }

            currSum = 0;
        } else {
            currSum += head->val;
        }

        solve(head->next, currSum, values);
    }
};