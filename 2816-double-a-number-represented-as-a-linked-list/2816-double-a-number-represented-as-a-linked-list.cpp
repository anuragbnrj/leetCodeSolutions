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
        // cout << "-------------" << endl;
        
        vector<int> arr(10002, 0);
        ListNode* curr = head;
        
        int sz = 1;
        for (ListNode* curr = head; curr; curr = curr->next) {
            arr[sz++] = curr->val;
        }
        
        int carry = 0;
        for (int i = sz; i >= 1; i--) {
            int curr = arr[i] * 2 + carry;
            
            if (curr > 9) {
                arr[i] = curr % 10;
                carry = curr / 10;
            } else {
                arr[i] = curr;
                carry = 0;
            }
        }
        
        ListNode* newHead;
        if (carry > 0) {
            arr[0] = carry;
            newHead = new ListNode();
            newHead->val = carry;
            newHead->next = head;
        } else {
            newHead = head;
        }
        
        sz = 1;
        for (ListNode* curr = head; curr; curr = curr->next) {
            curr->val = arr[sz++];
        }
        
        return newHead;
        
    }
};