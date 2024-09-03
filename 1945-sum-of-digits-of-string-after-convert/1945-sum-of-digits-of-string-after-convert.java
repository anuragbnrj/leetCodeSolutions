class Solution {
    public int getLucky(String s, int k) {
        char[] sarr = s.toCharArray();
        int n = sarr.length;

        String converted = "";
        for (int i = 0; i < n; i++) {
            converted += sarr[i] - 'a' + 1;
        }
        
        while (k > 0) {
            int sumOfDigits = 0;

            for (int i = 0; i < converted.length(); i++) {
                int digit = converted.charAt(i) - '0';
                sumOfDigits += digit;
            } 

            converted = Integer.toString(sumOfDigits);
            k -= 1;  
        }

        return Integer.parseInt(converted);
    }
}