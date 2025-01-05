/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int maxDepth = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        calcMaxDepth(nestedList, 1);
        return rec(nestedList, 1);
    }

    private int rec(List<NestedInteger> nestedList, int currDepth) {
        int ans = 0;
        int len = nestedList.size();
        for (int i = 0; i < len; i++) {
            NestedInteger curr = nestedList.get(i);

            if (!curr.isInteger()) {
                ans += rec(curr.getList(), currDepth + 1);
            } else {
                ans += (maxDepth - currDepth + 1) * curr.getInteger();
            }
        }

        return ans;
    }

    private void calcMaxDepth(List<NestedInteger> nestedList, int currDepth) {
        maxDepth = Math.max(maxDepth, currDepth);
        int len = nestedList.size();
        for (int i = 0; i < len; i++) {
            NestedInteger curr = nestedList.get(i);

            if (!curr.isInteger()) {
                calcMaxDepth(curr.getList(), currDepth + 1);
            }
        }
    }
}