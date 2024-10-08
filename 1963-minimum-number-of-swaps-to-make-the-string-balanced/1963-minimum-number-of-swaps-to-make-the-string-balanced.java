class Solution {
    public int minSwaps(String s) {
        int len = s.length();
        int beg = 0;
        int end = len - 1;

        int sum = 0;
        int swaps = 0;
        while (beg < end) {
            if (s.charAt(beg) == '[') {
                sum += 1;
            } else {
                sum -= 1;
            }

            if (sum < 0) {
                while (end > beg && s.charAt(end) == ']') {
                    end -= 1;
                }

                swaps += 1;
                sum += 2;
            }

            beg += 1;
        }


        return swaps;
    }
}