class Solution {

    int ans = 0;

    public int maxUniqueSplit(String s) {
        int len = s.length();

        HashSet<String> uniqueSubstrings = new HashSet<>();
        calculateMaxUniqueSubstrings(0, s, "", uniqueSubstrings);

        return ans;
    }

    private void calculateMaxUniqueSubstrings(int idx, String s, String prev, HashSet<String> uniques) {
        if (idx >= s.length()) {
            ans = Math.max(ans, uniques.size());
            return;
        }

        String temp = prev + s.charAt(idx);
        if (!uniques.contains(temp)) {
            uniques.add(temp);
            calculateMaxUniqueSubstrings(idx + 1, s, "", uniques);
            uniques.remove(temp);
        }
        
        calculateMaxUniqueSubstrings(idx + 1, s, temp, uniques);
    }

}