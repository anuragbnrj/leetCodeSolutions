class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        int len = meetings.size();
        vector<pair<int, int>> meets;
        for (int i = 0; i < len; i++) {
            meets.push_back({meetings[i][0], meetings[i][1]});
        }
        sort(meets.begin(), meets.end());

        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> inUse;
        priority_queue<int, vector<int>, greater<int>> empty;
        for (int i = 0; i < n; i++) { 
            empty.push(i);
        }

        vector<int> freq(n, 0);
        for (int i = 0; i < len; i++) {
            int currDuration = meets[i].second - meets[i].first;
            int currStart = meets[i].first;
            int currEnd = meets[i].second;

            while(inUse.size() > 0 && inUse.top().first <= currStart) {
                int inUseRoomNumber = inUse.top().second;
                inUse.pop();
                empty.push(inUseRoomNumber);
            }

            if (empty.size() > 0) {
                int emptyRoomNum = empty.top();
                empty.pop();

                inUse.push({meets[i].second, emptyRoomNum});
                freq[emptyRoomNum]++;
            } else {
                auto top = inUse.top();
                long long bestEnding = top.first;
                int bestEndingNum = top.second;
                inUse.pop();

                inUse.push({bestEnding + currDuration, bestEndingNum});
                freq[bestEndingNum]++;
            }
        }

        int res = INT_MIN;
        int roomNum = 0;
        for (int i = 0; i < n; i++) {
            cout << freq[i] << " ";
            if (freq[i] > res) {
                res = freq[i];
                roomNum = i;
            }
        }
        cout << endl;

        return roomNum;
    }
};