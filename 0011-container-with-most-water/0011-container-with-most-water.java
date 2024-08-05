class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int ans = 0;
        int currCapacity = 0;
        for (int beg = 0, end = n - 1; beg < end;) {
            currCapacity = Math.min(height[beg], height[end]) * (end - beg);

            ans = Math.max(ans, currCapacity);

            if (height[beg + 1] > height[beg]) {
                beg += 1;
            } else {
                end -= 1;
            }
        }

        return ans;
    }
}