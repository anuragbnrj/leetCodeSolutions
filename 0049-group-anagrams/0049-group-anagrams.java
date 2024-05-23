class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        Map<String, List<String>> mpp = new HashMap<>();
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String sortedStr = new String(strChars);
            List<String> anagrams = mpp.getOrDefault(sortedStr, new ArrayList<String>());
            anagrams.add(str);
            mpp.put(sortedStr, anagrams);
        }

        List<List<String>> res = new ArrayList<>();
        mpp.forEach((k, v) -> {
            res.add(v);
        });

        return res;
    }
}