class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        int len1 = nums1.size();
        int len2 = nums2.size();
        map<int, int> idxMap;
        stack<int> st;
        vector<int> nge(len2, -1);
        for (int i = 0; i < len2; i++) {
            idxMap[nums2[i]] = i;

            while(st.size() > 0 && nums2[st.top()] < nums2[i]) {
                int idx = st.top();
                st.pop();
                nge[idx] = nums2[i];
            }

            st.push(i);
        }
        
        vector<int> res;
        for (int i = 0; i < len1; i++) {
            int num = nums1[i];
            int idx = idxMap[num];
            res.push_back(nge[idx]);
        }

        return res;
    }
};