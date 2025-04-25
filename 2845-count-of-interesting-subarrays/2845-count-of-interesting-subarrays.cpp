class Solution {
public:
    long long countInterestingSubarrays(vector<int>& nums, int modulo, int k) {
        int len = nums.size();
    
        vector<int> csum(len + 1, 0);
        for (int i = 1; i <= len; i++) {
            csum[i] = csum[i - 1];
            if ((nums[i - 1] % modulo) == k) {
                csum[i] += 1;
            }
        }

        unordered_map<int, int> freq;
        long long tot = 0;
        for (int i = 1; i <= len; i++) {
            int curr = csum[i];
            int rem = curr % modulo;

            if (rem == k) {
                tot += 1;
            }

            int inv = rem - k;
            if (inv < 0) {
                inv += modulo;
            }

            if (freq.count(inv)) {
                tot += freq[inv];
            }

            if (freq.count(rem)) {
                freq[rem] += 1;
            } else {
                freq[rem] = 1;
            }


            // for (int j = 1; j <= i; j++) {
                
            //     if ((csum[i] - csum[j - 1]) % modulo == k) {
            //         res++;
            //     }
            // }
        }
        
        return tot;
    }
};