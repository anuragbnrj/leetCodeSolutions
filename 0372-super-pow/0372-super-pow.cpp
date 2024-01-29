class Solution {
public:
    int superPow(int a, vector<int>& b) {
        long long res = binPowMod(a, b, 1337);
        return res;
    }

private:
    long long binPowMod(int a, vector<int> &b, int m) {
        if (isZero(b)) {
            return 1;
        }
        int len = b.size();
        int ctr = 0;
        for (int i = 0; i < len; i++) {
            if (b[i] == 0) {
                ctr++;
            }
        }

        bool flag = isOdd(b);
        divideBy2(b);
        long long res = binPowMod(a, b, m);
        if (flag) {
            return ((res * res * a) % m);
        } else {
            return ((res * res) % m);
        }
    }

    bool isZero(vector<int> &b) {
        int len = b.size();
        int ctr = 0;
        for (int i = 0; i < len; i++) {
            if (b[i] == 0) {
                ctr++;
            }
        }

        if (ctr == len) {
            return true;
        }

        return false;
    }

    bool isOdd(vector<int> &b) {
        int len = b.size();
        if (b[len - 1] % 2 == 1) {
            return true;
        }

        return false;
    }

    void divideBy2(vector<int> &b) {
        int len = b.size();
        int rem = 0;
        for (int i = 0; i < len; i++) {
            int q = (rem * 10 + b[i]) / 2;
            rem = (rem * 10 + b[i]) % 2;
            b[i] = q;
        }
    }

};