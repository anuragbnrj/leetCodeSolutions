class Solution {

    int MOD = (int) 1e9 + 7;

    public int rangeSum(int[] nums, int n, int left, int right) {
        // Pair res = countSubarraysWithSum(nums, n, 3);
        // System.out.println("countSubarraysWithSum 3: " + res.count + ", " + res.sum);
        // res = countSubarraysWithSum(nums, n, 6);
        // System.out.println("countSubarraysWithSum 6: " + res.count + ", " + res.sum);
        
        long temp1 = sumOfFirstK(nums, n, right);
        long temp2 = sumOfFirstK(nums, n, left - 1);

        // System.out.println("temp1: " + temp1);
        // System.out.println("temp2: " + temp2);
        long ans = (temp1 - temp2) ;

        return (int) (ans % MOD);
    }

    private long sumOfFirstK(int[] nums, int n, int k) {
        int beg = MOD;
        int end = 0;
        for (int i = 0; i < n; i++) {
            beg = Math.min(beg, nums[i]);
            end += nums[i];
        }
        end += 1;

        // System.out.println("k: " + k);
        while (beg < end) {
            int mid = beg + ((end - beg) / 2);
            Pair res = countSubarraysWithSum(nums, n, mid);
            // System.out.println("mid: " + mid + ", count: " + res.count);

            if (res.count < k) beg = mid + 1;
            else end = mid;
        }

        Pair res = countSubarraysWithSum(nums, n, beg);
        // System.out.println("beg: " + beg + ", count: " + res.count + ", sum: " + res.sum);
        long sum = res.sum - beg * (res.count - k);

        return sum;
    }

    private Pair countSubarraysWithSum(int[] nums, int n, int mid) {
        int countOfSubarrays = 0;
        long sumOfSubarrays = 0;

        int tail = 0, head = -1;
        long currSum = 0;
        long currSubarraySum = 0; 
        while (tail < n) {
            while (head + 1 < n && ((currSum + nums[head + 1]) <= mid)) {
                head += 1;

                currSum += nums[head];
                currSubarraySum += currSum;
            }

            if (currSum <= mid) {
                countOfSubarrays += (head - tail + 1);
                sumOfSubarrays += currSubarraySum;
            }

            if (head < tail) {
                currSum = 0;
                currSubarraySum = 0;
                tail += 1;
                head = tail - 1;
            } else {
                currSum -= nums[tail];
                currSubarraySum -= (head - tail + 1) * nums[tail];
                tail += 1;
            }
        }

        return new Pair(countOfSubarrays, sumOfSubarrays);
    }

    static class Pair {
        int count;
        long sum;

        public Pair(int c, long s) {
            this.count = c;
            this.sum = s;
        }
    }
}