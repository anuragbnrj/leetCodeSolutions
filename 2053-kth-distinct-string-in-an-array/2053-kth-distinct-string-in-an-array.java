class Solution {
    public String kthDistinct(String[] arr, int k) {
        TreeMap<String, Integer> freq = new TreeMap<>();

        for (String str : arr) {
            int count = freq.getOrDefault(str, 0) + 1;
            freq.put(str, count);
        }

        String ans = "";
        int ctr = 0;
        for (String str : arr) {
            if (freq.get(str) == 1) {
                ctr += 1;
            }

            if (ctr == k) {
                ans = str;
                break;
            }
        }
        
        return ans;
    }
}