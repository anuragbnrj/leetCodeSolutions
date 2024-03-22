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
    bool isPalindrome(ListNode* head) {
        ListNode *slow = head;
        ListNode *fast = head;
        while (fast != NULL && fast->next != NULL) {
            fast = fast->next->next;
            slow = slow->next;
        }

        ListNode *prev = slow;
        ListNode *curr = slow->next;
        prev->next = NULL;
        ListNode *temp;
        while (curr != NULL) {
            temp = curr->next;            
            curr->next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode *beg = head;
        ListNode *end = prev;
        while (end != NULL) {
            if (beg->val != end->val) {
                return false;
            }

            beg = beg->next;
            end = end->next;
        }

        return true;   
    }
};