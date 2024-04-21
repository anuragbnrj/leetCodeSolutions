typedef long long ll;

class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        int beg = 1;
        int end = 2e9 + 1;

        vector<int> vec = addElements(a, b, c);

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (!check(n, a, b, c, mid, vec)) beg = mid + 1;
            else end = mid;
        }

        return beg;
    }

private:
    vector<int> addElements(int a, int b, int c) {
        set<int> stt;
        stt.insert(a);
        stt.insert(b);
        stt.insert(c);

        vector<int> res;
        for (int el : stt) {
            int flag = true;
            for (int i = 0; i < res.size(); i++) {
                if (el % res[i] == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                res.push_back(el);
            }

        }

        return res;
    }

    bool check(int n, int a, int b, int c, ll mid, vector<int> vec) {
        int res = 0;
        for (int i = 0; i < vec.size(); i++) {
            res += (mid / vec[i]);
            for (int j = 0; j < i; j++) {
                res -= (mid / lcm(vec[i], vec[j]));
            }
        }
        
        return (res >= n);
    }

    long long gcd(long long a, long long b) {
        while (b) {
            a %= b;
            swap(a, b);
        }
        return a;
    }

    long long lcm(long long a, long long b) {
        return (a / gcd(a, b)) * b;
    }
};