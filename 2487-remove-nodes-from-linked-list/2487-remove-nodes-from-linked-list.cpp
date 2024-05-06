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
    ListNode* removeNodes(ListNode* head) {
        ListNode *temp = head;
        stack<ListNode *> st;
        while (temp != nullptr) {
            while(st.size() > 0 && temp->val > (st.top())->val) {
                st.pop();
            }

            st.push(temp);
            temp = temp->next;
        }

        ListNode *newHead = nullptr;
        stack<ListNode *> rev;
        while(!st.empty()) {
            ListNode *top = st.top();
            st.pop();

            top->next = nullptr;
            rev.push(top);
        }

        ListNode *dummy = new ListNode();
        ListNode *prev = dummy;
        while (!rev.empty()) {
            ListNode *top = rev.top();
            rev.pop();

            prev->next = top;
            prev = prev->next;
        }

        return dummy->next;
    }
};