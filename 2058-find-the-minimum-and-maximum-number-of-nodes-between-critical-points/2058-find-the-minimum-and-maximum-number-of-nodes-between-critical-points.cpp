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
    int INF = 1e9;
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {

        ListNode* temp = head;
        vector<int> arr;
        while (temp != nullptr) {
            arr.push_back(temp->val);
            temp = temp->next;
        }

        if (arr.size() <= 2) {
            return {-1, -1};
        }
        
        vector<int> ans = {INF, 0};
        int firstCritical = 0;
        int prevCritical = 0;
        for (int i = 1; i < arr.size() - 1; i++) {
            if ((arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) ||
                (arr[i - 1] > arr[i] && arr[i] < arr[i + 1])) {
                if (firstCritical == 0) {
                    firstCritical = i;
                    prevCritical = i;
                } else {
                    ans[0] = min(ans[0], i - prevCritical);
                    ans[1] = max(ans[1], i - firstCritical);

                    prevCritical = i;
                }
            }
        }

        if (ans[1] == 0) {
            return {-1, -1};
        }

        return ans;
    }
};