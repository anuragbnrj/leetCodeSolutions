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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* temp = head;
        int len = 0;
        while (temp != nullptr) {
            len++;
            temp= temp->next;
        }

        int k = len - n + 1;
        temp = head;
        int curr = 1;
        while (curr < (k - 1)) {
            temp = temp->next;
            curr++;
        }

        if (temp->next == nullptr) {
            return nullptr;
        }

        if (k == 1) {
            head = temp->next;
            return head;
        }


        temp->next = temp->next->next;
        return head;
    }
};