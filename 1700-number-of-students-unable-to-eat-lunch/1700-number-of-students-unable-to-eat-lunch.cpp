class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        int n = students.size();
        stack<int> st;
        for (int i = n - 1; i >= 0; i--) {
            st.push(sandwiches[i]);
        }
        deque<int> dq(students.begin(), students.end());

        int res = 0;
        while (true) {
            if (dq.size() == 0) {
                res = 0;
                break;
            }

            int skipped = 0;
            while (dq.front() != st.top() && skipped < dq.size()) {
                int student = dq.front();
                dq.pop_front();
                dq.push_back(student);
                skipped++;
            }

            if (skipped == dq.size()) {
                res = dq.size();
                break;
            }

            if (dq.front() == st.top()) {
                dq.pop_front();
                st.pop();
            }
        }

        return res;
    }
};