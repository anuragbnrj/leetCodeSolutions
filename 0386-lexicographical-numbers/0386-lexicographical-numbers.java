class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            generateNumbers(Integer.toString(i), n, ans);
        }
        
        return ans;
    }

    private void generateNumbers(String curr, int maxNum, List<Integer> ans) {
        int currNum = Integer.parseInt(curr);

        if (currNum > maxNum || currNum == 0) {
            return;
        }

        if (currNum != 0) {
            ans.add(currNum);
        }

        for (int i = 0; i <= 9; i++) {
            generateNumbers(curr + i, maxNum, ans);
        }
    }
}