class Solution {
    public int maxDiff(int num) {
        String numStr = Integer.toString(num);

        int pos = 0;
        while (pos < numStr.length() && numStr.charAt(pos) == '9') {
            pos++;
        }
        String maxNumStr = numStr;
        if (pos < numStr.length()) {
            maxNumStr = numStr.replace(numStr.charAt(pos), '9');
        }

        pos = 0;
        while (pos < numStr.length() && (numStr.charAt(pos) == '1' || numStr.charAt(pos) == '0')) {
            pos++;
        }
        String minNumStr = numStr;
        if (pos == 0) {
            minNumStr = numStr.replace(numStr.charAt(pos), '1');
        } else if (pos > 0 && pos < numStr.length()) {
             minNumStr = numStr.replace(numStr.charAt(pos), '0');
        }
        
        return Integer.parseInt(maxNumStr) - Integer.parseInt(minNumStr);
    }
}