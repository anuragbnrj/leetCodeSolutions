class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int len = a.length;

        Set<Integer> visitedA = new HashSet<>();
        Set<Integer> visitedB = new HashSet<>();
        int[] ans = new int[len];
        int seen = 0;
        for (int i = 0; i < len; i++) {
            int elA = a[i];
            if (visitedB.contains(elA)) {
                seen++;
            }
            visitedA.add(elA);

            int elB = b[i];
            if (visitedA.contains(elB)) {
                seen++;
            }
            visitedB.add(elB);

            ans[i] = seen;
        }

        return ans;
    }
}