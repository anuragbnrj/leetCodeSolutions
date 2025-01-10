/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    int currPtr;
    List<Integer> flattenedList;

    public NestedIterator(List<NestedInteger> nestedList) {
        currPtr = -1;
        flattenedList = new ArrayList<>();

        flattenList(nestedList);
    }

    private void flattenList(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger curr = nestedList.get(i);

            if (curr.isInteger()) {
                flattenedList.add(curr.getInteger());
            } else {
                flattenList(curr.getList());
            }
        }
    }

    @Override
    public Integer next() {
        currPtr += 1;
        return flattenedList.get(currPtr);
    }

    @Override
    public boolean hasNext() {
        return currPtr < flattenedList.size() - 1;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */