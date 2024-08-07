class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String ans = "";
        String numStr = Integer.toString(num);

        int len = numStr.length();

        while (numStr.length() < 10) {
            numStr = '0' + numStr;
        }

        int billion = Integer.parseInt(numStr.substring(0, 1));
        int million = Integer.parseInt(numStr.substring(1, 4));
        int thousand = Integer.parseInt(numStr.substring(4, 7));
        int rest = Integer.parseInt(numStr.substring(7, 10));

        if (billion > 0) {
            ans += convert(billion) + " " + "Billion";
        }

        if (million > 0) {
            if (ans.length() > 0) ans += " ";
            ans += convert(million) + " " + "Million";
        }

        if (thousand > 0) {
            if (ans.length() > 0) ans += " ";
            ans += convert(thousand) + " " + "Thousand";
        }

        if (rest > 0) {
            if (ans.length() > 0) ans += " ";
            ans += convert(rest);
        }

        return ans;
    }

    private String convert(int num) {
        int temp = num;

        int lastTwo = num % 100;

        int ones = temp % 10;
        temp /= 10;
        int tens = temp % 10;
        temp /= 10;
        int huns = temp % 10;

        String[] mapping = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        String ans = "";
        if (lastTwo == 1) {
            ans += "One";
        } else if (lastTwo == 2) {
            ans += "Two";
        } else if (lastTwo == 3) {
            ans += "Three";
        } else if (lastTwo == 4) {
            ans += "Four";
        } else if (lastTwo == 5) {
            ans += "Five";
        } else if (lastTwo == 6) {
            ans += "Six";
        } else if (lastTwo == 7) {
            ans += "Seven";
        } else if (lastTwo == 8) {
            ans += "Eight";
        } else if (lastTwo == 9) {
            ans += "Nine";
        } else if (lastTwo == 10) {
            ans += "Ten";
        } else if (lastTwo == 11) {
            ans += "Eleven";
        } else if (lastTwo == 12) {
            ans += "Twelve";
        } else if (lastTwo == 13) {
            ans += "Thirteen";
        } else if (lastTwo == 14) {
            ans += "Fourteen";
        } else if (lastTwo == 15) {
            ans += "Fifteen";
        } else if (lastTwo == 16) {
            ans += "Sixteen";
        } else if (lastTwo == 17) {
            ans += "Seventeen";
        } else if (lastTwo == 18) {
            ans += "Eighteen";
        } else if (lastTwo == 19) {
            ans += "Nineteen";
        } else {
            if (tens == 2) {
                ans = "Twenty" + ans;
            } else if (tens == 3) {
                ans = "Thirty" + ans;
            } else if (tens == 4) {
                ans = "Forty" + ans;
            } else if (tens == 5) {
                ans = "Fifty" + ans;
            } else if (tens == 6) {
                ans = "Sixty" + ans;
            } else if (tens == 7) {
                ans = "Seventy" + ans;
            } else if (tens == 8) {
                ans = "Eighty" + ans;
            } else if (tens == 9) {
                ans = "Ninety" + ans;
            }

            if (ones > 0) {
                ans = ans + " " + mapping[ones];
            }  
        }

        if (huns > 0) {
            ans = mapping[huns] + " Hundred " + ans;
        }

        return ans;
    }
}