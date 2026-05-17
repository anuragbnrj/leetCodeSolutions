class Solution {
    public boolean canReach(int[] arr, int start) {
        int[] visited = new int[arr.length];
        Arrays.fill(visited, -1);

        return rec(start, arr, visited);
    }

    private boolean rec(int idx, int[] arr, int[] visited) {
        if (arr[idx] == 0) {
            return true;
        }

        if (visited[idx] == -2) {
            return false;
        }

        if (visited[idx] == 0) {
            return false;
        }

        if (visited[idx] == 1) {
            return true;
        }

        boolean ans = false;
        visited[idx] = -2;
        if (idx + arr[idx] < arr.length) {
            ans = ans || rec(idx + arr[idx], arr, visited);
        }
        if (idx - arr[idx] >= 0) {
            ans = ans || rec(idx - arr[idx], arr, visited);
        }

        if (ans) {
            visited[idx] = 1;
        } else {
            visited[idx] = 0;
        }

        return ans;
    }


}