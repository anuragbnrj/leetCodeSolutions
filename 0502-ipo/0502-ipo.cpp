class Solution {
    struct project {
        int cap;
        int pro;
        int net;
        project (int c = 0, int p = 0, int n = 0) {
            cap = c;
            pro = p;
            net = n;
        }
    };

    struct node {
        int maxNet;
        int idx;
        node (int mx = 0, int i = -1) {
            maxNet = mx;
            idx = i;
        }
    };

    struct cmp {
        bool operator()(const project &x, const project &y) const { return x.cap < y.cap; }
    };

public:
    vector<project> a;
    vector<node> segtree;

    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        int n = profits.size();
        a.resize(n);
        segtree.resize(4 * n);

        for (int i = 0; i < n; i++) {
            a[i] = project(capital[i], profits[i], profits[i] - capital[i]);
        }

        sort(a.begin(), a.end(), cmp());
        build(1, 0, n - 1);

        int currCapital = w;
        for (int i = 0; i < k; i++) {
            int idx = upperBound(currCapital, n);
            idx--;

            if (idx >= 0) {
                node temp = query(1, 0, n - 1, 0, idx);

                if (temp.maxNet > 0) {
                    currCapital += temp.maxNet;
                    update(1, 0, n - 1, temp.idx, 0);
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        return currCapital;
    }

private:
    int upperBound(int capital, int n) {
        int beg = 0;
        int end = n;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;

            if (a[mid].cap <= capital) beg = mid + 1;
            else end = mid;
        }

        return beg;
    }

    void build(int idx, int l, int r) {
        if (l == r) {
            segtree[idx] = node(a[l].pro, l);
            return;
        }

        int mid = l + (r - l) / 2;

        build(2 * idx, l, mid);
        build(2 * idx + 1, mid + 1, r);
        segtree[idx] = merge(segtree[2 * idx], segtree[2 * idx + 1]);
    }

    node merge(node n1, node n2) {
        if (n1.maxNet > n2.maxNet) {
            return n1;
        } else {
            return n2;
        }
    }

    void update(int idx, int l, int r, int pos, int val) {
        if (pos < l || r < pos) {
            return;
        }

        if (l == r) {
            a[l].pro = val;
            segtree[idx].maxNet = val;
            return; 
        }

        int mid = l + (r - l) / 2;
        update(2 * idx, l, mid, pos, val);
        update(2 * idx + 1, mid + 1, r, pos, val);

        segtree[idx] = merge(segtree[2 * idx], segtree[2 * idx + 1]);
    }

    node query(int idx, int l, int r, int lq, int rq) {
        if (rq < l || r < lq) {
            return node(0, -1);
        }

        if (lq <= l && r <= rq) {
            return segtree[idx];
        }

        int mid = l + (r - l) / 2;

        return merge(query(2 * idx, l, mid, lq, rq), query(2 * idx + 1, mid + 1, r, lq, rq));
    }
};