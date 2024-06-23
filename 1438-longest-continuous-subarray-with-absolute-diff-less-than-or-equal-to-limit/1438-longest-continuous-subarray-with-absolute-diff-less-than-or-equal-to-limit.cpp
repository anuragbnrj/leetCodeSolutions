struct node {
    int mn;
    int mx;
    node(int minn = 1e9 + 1, int maxx = 0) {
        mn = minn;
        mx = maxx;
    }
};

class Solution {
public:
    int a[100010];
    node segtree[400040];

    node merge(node n1, node n2) {
        int mn = min(n1.mn, n2.mn);
        int mx = max(n1.mx, n2.mx);
        return node(mn, mx);
    }

    void build(int idx, int l, int r) {
        if (l == r) {
            segtree[idx] = node(a[l], a[l]);
            return;
        }

        int mid = l + (r - l) / 2;

        build(2 * idx, l, mid);
        build(2 * idx + 1, mid + 1, r);
        segtree[idx] = merge(segtree[2 * idx], segtree[2 * idx + 1]);
    }

    void update(int idx, int l, int r, int pos, int val) {
        if (pos < l || r < pos) {
            return;
        }

        if (l == r) {
            segtree[idx] = node(a[l], a[l]);
            return;
        }

        int mid = l + (r - l) / 2;

        update(2 * idx, l, mid, pos, val);
        update(2 * idx + 1, mid + 1, r, pos, val);

        segtree[idx] = merge(segtree[2 * idx], segtree[2 * idx + 1]);
    }

    node query(int idx, int l, int r, int lq, int rq) {
        if (rq < l || r < lq) {
            return node(1e9 + 1, 0);
        }

        if (lq <= l && r <= rq) {
            return segtree[idx];
        }

        int mid = l + (r - l) / 2;

        return merge(query(2 * idx, l, mid, lq, rq),
                     query(2 * idx + 1, mid + 1, r, lq, rq));
    }

    int longestSubarray(vector<int>& nums, int limit) {
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
        }

        build(1, 0, n - 1);

        int ans = 0;
        for (int beg = 0, end = 0; end < n; end++) {
            node temp = query(1, 0, n - 1, beg, end);

            // cout << "beg: " << beg << ", end: " << end
            //          << ", temp.mn: " << temp.mn << ", temp.mx: " << temp.mx
            //          << endl;

            if (abs(temp.mx - temp.mn) <= limit) {
                ans = max(ans, end - beg + 1);
            }

            while (abs(temp.mx - temp.mn) > limit && beg < end) {
                beg++;
                temp = query(1, 0, n - 1, beg, end);
            }
        }

        return ans;
    }
};