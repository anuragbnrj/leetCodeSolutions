class Solution {
public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        
        // Find the maximum day to determine array size
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }
        
        // Union-Find to efficiently skip occupied days
        int[] parent = new int[maxDay + 2]; // +2 to handle day after maxDay
        for (int i = 0; i <= maxDay + 1; i++) {
            parent[i] = i;
        }
        
        int attendedEvents = 0;
        
        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            
            // Find the earliest available day using Union-Find
            int availableDay = find(parent, start);
            
            if (availableDay <= end) {
                attendedEvents++;
                // Union this day with the next day (mark as occupied)
                union(parent, availableDay, availableDay + 1);
            }
        }
        
        return attendedEvents;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    
    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}