class Solution {
    private final long MOD = (long) 1e9 + 7;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        HashSet<Integer> hlens = new HashSet<>();
        for (int i = 0; i < hFences.length; i++) {
            hlens.add(hFences[i] - 1);
            for (int j = 0; j < i; j++) {
                hlens.add(hFences[i] - hFences[j]);
            }
            hlens.add(m - hFences[i]);
        }
        hlens.add(m - 1);
        

        Arrays.sort(vFences);
        HashSet<Integer> vlens = new HashSet<>();
        for (int i = 0; i < vFences.length; i++) {
            vlens.add(vFences[i] - 1);
            for (int j = 0; j < i; j++) {
                vlens.add(vFences[i] - vFences[j]);
            }
            vlens.add(n - vFences[i]);
        }
        vlens.add(n - 1);

        long ans = -1;
        for (int vlen : vlens) {
            if (hlens.contains(vlen)) {
                ans = Math.max(ans, 1L * vlen * vlen);
            }
        }

        return (int) (ans % MOD);    
    }
}