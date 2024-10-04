class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> val = new HashMap<>();
        val.put('I', 1);
        val.put('V', 5);
        val.put('X', 10);
        val.put('L', 50);
        val.put('C', 100);
        val.put('D', 500);
        val.put('M', 1000);

        int len = s.length();
        int total = 0;
        char[] sarr = s.toCharArray();
        for (int i = 0; i < len; i++) {
            char ch = sarr[i];
            total += val.get(ch);

            if ((ch == 'V' || ch == 'X') && i > 0 && sarr[i - 1] == 'I') {
                total -= 2 * val.get('I');
            }

            if ((ch == 'L' || ch == 'C') && i > 0 && sarr[i - 1] == 'X') {
                total -= 2 * val.get('X');
            }

            if ((ch == 'D' || ch == 'M') && i > 0 && sarr[i - 1] == 'C') {
                total -= 2 * val.get('C');
            }
        }

        return total;
    }
}