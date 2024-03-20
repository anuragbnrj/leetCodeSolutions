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
    ListNode* mergeInBetween(ListNode* list1, int a, int b, ListNode* list2) {
        ListNode* dummy = new ListNode();
        dummy->next = list1;

        ListNode* prevL = dummy;
        int ctr = -1;
        while (ctr < a - 1) {
            prevL = prevL->next;
            ctr++;
        }

        ListNode* prevR = dummy;
        ctr = -1;
        while (ctr < b) {
            prevR = prevR->next;
            ctr++;
        }

        prevL->next = list2;
        ListNode* temp = list2;
        while (temp->next != nullptr) {
            temp = temp->next;
        }
        temp->next = prevR->next;
        prevR->next = nullptr;

        return dummy->next;
         
    }
};