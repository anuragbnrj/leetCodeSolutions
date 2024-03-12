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
    ListNode* removeZeroSumSublists(ListNode* head) {
        ListNode* dummy = new ListNode(0);
        unordered_map<int, ListNode*> mpp;
        int currSum;
        dummy->next = head;
        mpp[0] = dummy;

        for (ListNode* curr = head; curr != nullptr; curr = curr->next) {
            currSum += curr->val;

            if (mpp.count(currSum) != 0) {
                ListNode* prev = mpp[currSum];
                int sum = currSum;
                ListNode* temp = prev;
                while (temp != curr) {
                    temp = temp->next;
                    sum += temp->val;

                    if (temp != curr) {
                        mpp.erase(sum);
                    }
                } 

                prev->next = curr->next;
            } else {
                mpp[currSum] = curr;
            }
        }

        return dummy->next;
    }
};