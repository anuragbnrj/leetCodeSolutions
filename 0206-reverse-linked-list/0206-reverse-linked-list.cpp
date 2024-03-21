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
    ListNode* reverseList(ListNode* head) {
        if (head == nullptr) {
            return nullptr;
        }

        ListNode* dummy = new ListNode(0);
        dummy->next = head;

        ListNode* temp = head;
        ListNode* prev = dummy;
        while (temp != nullptr) {
            ListNode* curr = temp;
            temp = temp->next;
            curr->next = prev;
            prev = curr;
        }

        head->next = nullptr;

        return prev;
        
    }
};