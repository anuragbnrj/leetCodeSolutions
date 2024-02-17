class Solution {
public:
    int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
        // cout << "-------------" << endl;
        int len = heights.size();

        int mxIndex = 0;
        long long kLargestSum = 0;
        long long totalDiff = 0;
        priority_queue<int, vector<int>, greater<int>> heap;
        for (int i = 1; i < len; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                totalDiff += diff;
                if (heap.size() < ladders) {
                    heap.push(diff); 
                    kLargestSum += diff;
                } else {
                    if (heap.size() && diff > heap.top()) {
                        int top = heap.top();
                        kLargestSum = kLargestSum - top;
                        heap.pop();

                        heap.push(diff);
                        kLargestSum += diff;
                    }
                }

                int bricksRequired = totalDiff - kLargestSum;
                if (bricksRequired <= bricks) {
                    mxIndex = i;
                } else {
                    break;
                }

            } else {
                mxIndex = i;
            }

            // cout << i << endl;
        }


        return mxIndex;
    }
};