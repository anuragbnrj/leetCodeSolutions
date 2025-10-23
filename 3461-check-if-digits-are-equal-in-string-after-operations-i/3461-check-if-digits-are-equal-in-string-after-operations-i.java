class Solution {
    public boolean hasSameDigits(String s) {
        String temp = s;

        while (temp.length() > 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < temp.length(); i++) {
                int curr = temp.charAt(i) - '0';
                int prev = temp.charAt(i - 1) - '0';

                int combinedDigit = (curr + prev) % 10;

                sb.append((char) ('0' + combinedDigit));
            }

            temp = sb.toString();
        }

        return temp.charAt(0) == temp.charAt(1);
    }
}