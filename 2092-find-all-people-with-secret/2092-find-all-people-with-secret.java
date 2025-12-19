class Solution {

    private int[] parent;

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        union(0, firstPerson);

        Arrays.sort(meetings, (a, b) -> {
            return Integer.compare(a[2], b[2]);
        });

        for (int i = 0; i < meetings.length; ) {
            int t = meetings[i][2];

            for (int j = i; j < meetings.length && meetings[j][2] == t; j++) {
                int u = meetings[j][0];
                int v = meetings[j][1];

                union(u, v);
            }

            int j = i;
            for ( ; j < meetings.length && meetings[j][2] == t; j++) {
                int u = meetings[j][0];
                int pu = findParent(u);
                if (pu != 0) {
                    parent[u] = u;
                }

                int v = meetings[j][1];
                int pv = findParent(v);
                if (pv != 0) {
                    parent[v] = v;
                }
            }

            // System.out.println("i: " + i);
            // System.out.println(Arrays.toString(parent));

            i = j;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (findParent(i) == 0) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == 0) {
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
        }
    }

    private int findParent(int u) {
        if (parent[u] != u) {
            parent[u] = findParent(parent[u]);
        }

        return parent[u];
    }
}