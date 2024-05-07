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
    ListNode* doubleIt(ListNode* head) {
        ListNode *revHead = reverse(head);

        ListNode *curr = revHead, *prev = nullptr;
        int carry = 0;
        while(curr != nullptr) {
            int val = curr->val * 2 + carry;

            if (val > 9) {
                carry = val / 10;
            } else {
                carry = 0;
            }

            curr->val = val % 10;
            prev = curr;
            curr = curr->next;
        }

        if (carry > 0) {
            ListNode *newNode = new ListNode();
            newNode->val = carry;
            newNode->next = nullptr;
            prev->next = newNode;
        }

        return reverse(revHead);
    }

private:
    ListNode* reverse(ListNode* head) {
        ListNode *prev = nullptr, *curr = head, *temp = nullptr;

        while (curr != nullptr) {
            temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
};