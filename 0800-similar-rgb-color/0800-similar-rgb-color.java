class Solution { 
    public String findTarget(String colorSection) {
        int num = Integer.parseInt(colorSection, 16);

        int ans = -1, minDiff = 1000;

        for (int i = 0; i < 16; ++i) {
            int curDiff = (int)Math.pow(i * 17 - num, 2);
            if (curDiff < minDiff) {
                minDiff = curDiff;
                ans = i;
            }
        }

        return Integer.toHexString(ans).repeat(2);
    }
    
    public String similarRGB(String color) {
        StringBuilder targetColor = new StringBuilder();
        targetColor.append("#");
        
        for (int i = 1; i < 6; i += 2) {
            targetColor.append(findTarget(color.substring(i, i + 2)));
        }
        
        return targetColor.toString();
    }
}