class Solution {
public:
    int maximumScore(int a, int b, int c) {
        priority_queue<int> pq;
        pq.push(a);
        pq.push(b);
        pq.push(c);

        bool flag = true;
        int moves = 0;
        while (flag) {
            int n1 = pq.top();
            pq.pop();

            int n2 = pq.top();
            pq.pop();

            if (n1 == 0 || n2 == 0) {
                flag = false;
            } else {
                n1 = n1 - 1;
                pq.push(n1);

                n2 = n2 - 1;
                pq.push(n2);

                moves++;
            }
        }

        return moves;
    }
};