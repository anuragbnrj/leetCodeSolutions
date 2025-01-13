class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        boolean[] visited = new boolean[nums.length];
        boolean ans = isSumPossible(nums, sum / k, 0, 0, visited, 0, k, 0);
        
        return ans;
    }

    private boolean isSumPossible(int[] nums, int sumPerPartition, int idx, int currSum, boolean[] visited, int currIter, int k, int partitionsFound) {
        if (currIter == k) {
            if (partitionsFound != k) {
                return false;
            }
            return true;
        }

        if (idx == nums.length) {
            if (currSum == sumPerPartition) {
                return true;
            } else {
                return false;
            }
        }

        boolean ans = false;
        if (visited[idx] == false) {
            visited[idx] = true;

            if ((currSum + nums[idx]) < sumPerPartition) {
                ans = ans || isSumPossible(nums, sumPerPartition, idx + 1, currSum + nums[idx], visited, currIter, k, partitionsFound);
            } else if ((currSum + nums[idx]) == sumPerPartition) {
                ans = ans || isSumPossible(nums, sumPerPartition, 0, 0, visited, currIter + 1, k, partitionsFound + 1);
            } 
            
            visited[idx] = false; 
        } 
        ans = ans || isSumPossible(nums, sumPerPartition, idx + 1, currSum, visited, currIter, k, partitionsFound);
        
        return ans;
    }
}
