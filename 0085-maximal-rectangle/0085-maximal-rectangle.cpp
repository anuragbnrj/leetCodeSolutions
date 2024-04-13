class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        int res = INT_MIN;

        vector<vector<int>> height(rows, vector<int>(cols, 0));


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0) {
                    height[i][j] = (int) matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '1') {
                        height[i][j] = height[i - 1][j] + 1;
                    } else {
                        height[i][j] = 0;
                    }
                }
                
            }
            
            int mx_area_in_row = largestRectangleArea(height[i]);
            res = max(res, mx_area_in_row);
        }

        return res;
    }


    int largestRectangleArea(vector<int>& heights) {
        int len = heights.size();

        vector<int> next_smaller_idx(len, len);
        vector<int> prev_smaller_idx(len, -1);

        stack<int> st;
        for (int i = len - 1; i >= 0; i--) {
            // loop till we have a lesser element on top or stack becomes empty.
            while (!st.empty())
            {
                // pop elements that aren't lesser than the current element
                if (heights[st.top()] >= heights[i]) {
                    st.pop();
                }
                // the next leser element is now on the top of the stack
                else {
                    next_smaller_idx[i] = st.top();
                    break;
                }
            }
    
            // push current element into the stack
            st.push(i);
        }

        while(!st.empty()) {
            st.pop();
        }


        for (int i = 0; i < len; i++) {
            // loop till we have a lesser element on top or stack becomes empty.
            while (!st.empty())
            {
                // pop elements that aren't lesser than the current element
                if (heights[st.top()] >= heights[i]) {
                    st.pop();
                }
                // the next leser element is now on the top of the stack
                else {
                    prev_smaller_idx[i] = st.top();
                    break;
                }
            }
    
            // push current element into the stack
            st.push(i);
        }

        int res = INT_MIN;
        for (int i = 0; i < len; i++) {
            int ar = 0;
            int left = prev_smaller_idx[i];
            int right = next_smaller_idx[i];

            ar = (heights[i] * (right - left - 1));

            res = max(res, ar);
        }

        return res;
    }




};