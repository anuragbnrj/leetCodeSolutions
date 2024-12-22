class SegmentTreeMax {
    private int[] arr;        // Original array
    private int[] segTree;    // Segment tree array
    private int n;            // Size of the original array

    // Constructor
    public SegmentTreeMax(int[] array) {
        n = array.length;
        arr = array.clone();
        // Size of segment tree array = 4 * n (to ensure enough space)
        segTree = new int[4 * n];
        // Build the segment tree
        build(1, 0, n - 1);
    }

    // Build segment tree
    private void build(int idx, int left, int right) {
        if (left == right) {
            segTree[idx] = arr[left];
            return;
        }

        int mid = left + (right - left) / 2;
        build(2 * idx, left, mid);          // Build left subtree
        build(2 * idx + 1, mid + 1, right); // Build right subtree

        // Internal node will have the maximum of both its children
        segTree[idx] = Math.max(segTree[2 * idx], segTree[2 * idx + 1]);
    }

    // Update value at a given position
    public void update(int pos, int val) {
        arr[pos] = val;
        updateUtil(1, 0, n - 1, pos, val);
    }

    private void updateUtil(int idx, int left, int right, int pos, int val) {
        if (pos < left || right < pos) {
            return;
        }

        if (left == right) {
            segTree[idx] = val;
            return;
        }

        int mid = left + (right - left) / 2;
        updateUtil(2 * idx, left, mid, pos, val);
        updateUtil(2 * idx + 1, mid + 1, right, pos, val);

        segTree[idx] = Math.max(segTree[2 * idx], segTree[2 * idx + 1]);
    }

    // Query maximum in range [queryLeft, queryRight]
    public int query(int queryLeft, int queryRight) {
        return queryUtil(1, 0, n - 1, queryLeft, queryRight);
    }

    private int queryUtil(int idx, int left, int right, int queryLeft, int queryRight) {
        // No overlap
        if (queryRight < left || right < queryLeft) {
            return Integer.MIN_VALUE;
        }

        // Complete overlap
        if (queryLeft <= left && right <= queryRight) {
            return segTree[idx];
        }

        // Partial overlap - check both children
        int mid = left + (right - left) / 2;
        int leftMax = queryUtil(2 * idx, left, mid, queryLeft, queryRight);
        int rightMax = queryUtil(2 * idx + 1, mid + 1, right, queryLeft, queryRight);

        return Math.max(leftMax, rightMax);
    }
}

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        SegmentTreeMax segmentTreeObj = new SegmentTreeMax(heights);

        int ql = queries.length;
        int[] ans = new int[ql];
        for (int i = 0; i < ql; i++) {
            int[] query = queries[i];
            int left = Math.min(query[0], query[1]);
            int right = Math.max(query[0], query[1]);

            if (left == right || heights[left] < heights[right]) {
                ans[i] = right;
            } else {
                int mx = heights[left];
                int beg = right;
                int end = heights.length - 1;

                while (beg < end) {
                    int mid = beg + (end - beg) / 2;

                    if (segmentTreeObj.query(beg, mid) < mx) beg = mid + 1;
                    else end = mid; 
                }

                if (heights[beg] <= mx) {
                    ans[i] = -1;
                } else {
                    ans[i] = beg;
                }
            }
        }

        return ans;
    }
}
