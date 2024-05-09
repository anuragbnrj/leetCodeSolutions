class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        List<Integer> h = Arrays.stream(happiness).boxed().collect(Collectors.toList());
        Collections.sort(h);
        Collections.reverse(h);

        long res = 0L;
        for (int i = 0; i < k; i++) {
            res += Math.max(0, h.get(i) - i);
        }
        
        return res;
    }
}