class Solution {
    public int minOperations(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int num : nums) {
            while (!st.isEmpty() && st.peek() > num) {
                st.pop();
            }

            if (num == 0) continue;

            if (st.isEmpty() || num > st.peek()) {
                ans += 1;
                st.push(num);
            }
        }

        return ans;
    }
}