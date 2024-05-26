class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        map<int, long long> countMap;

        for (int num : nums2) {
            int divisor = num * k;
            countMap[divisor]++;
        }

        long long count = 0;
        for (int num : nums1) {
            for (int i = 1; i <= sqrt(num); i++) {
                if (num % i == 0) {
                    int divisor1 = i;
                    int divisor2 = num / i;
                    
                    count += countMap[divisor1];
                    
                    if (divisor1 != divisor2) {
                        count += countMap[divisor2];
                    }
                }
            }
        }

        return count;
    }
};