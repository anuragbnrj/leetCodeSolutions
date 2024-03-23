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
    void reorderList(ListNode* head) {
        ListNode *slow = head;
        ListNode *fast = head;

        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }

        ListNode *curr = slow;
        ListNode *prev = nullptr;
        while (curr != nullptr) {
            ListNode *next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }

        ListNode *a = head;
        ListNode *b = prev;

        while (a != nullptr && a->next != nullptr && b != nullptr && b->next != nullptr) {
            ListNode *nexta = a->next;
            ListNode *nextb = b->next;

            a->next = b;
            b->next = nexta;

            a = nexta;
            b = nextb;
        }
        
    }
};