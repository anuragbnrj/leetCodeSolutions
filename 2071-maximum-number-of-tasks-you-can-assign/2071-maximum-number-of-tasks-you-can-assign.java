class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int tasksLen = tasks.length;
        int tasksPtr = 0;
        int workersLen = workers.length;
        int workersPtr = 0;

        int ans = 0;
        while (tasksPtr < tasksLen && workersPtr < workersLen) {
            int taskSize = tasks[tasksPtr];
            int workerSize = workers[workersPtr];

            if (workerSize >= taskSize) {
                tasksPtr += 1;
                workersPtr += 1;
                ans += 1;
            } else {
                if (pills > 0 && workerSize + strength >= taskSize) {
                    pills -= 1;

                    tasksPtr += 1;
                    workersPtr += 1;
                    ans += 1;
                } else {
                    workersPtr += 1;
                }
            }
        }

        return ans;
    }
}