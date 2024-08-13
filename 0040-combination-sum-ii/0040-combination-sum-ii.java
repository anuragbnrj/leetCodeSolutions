class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> currElements = new ArrayList<>();
        solve(0, target, candidates, ans, currElements);

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> aList : ans) {
            res.add(aList);
        }
        return res;
    }

    private void solve (int idx, int reqd, int[] candidates, Set<List<Integer>> ans, List<Integer> currElements) {
        if (reqd == 0) {
            ans.add(new ArrayList<>(currElements));
        }

        if (idx == candidates.length) {
            return;
        }

        if (candidates[idx] > reqd) {
            return;
        }

        // pick
        currElements.add(candidates[idx]);
        solve(idx + 1, reqd - candidates[idx], candidates, ans, currElements);

        // not pick - also remove last element added
        currElements.remove(currElements.size() - 1);
        solve(idx + 1, reqd, candidates, ans, currElements);
    }
}