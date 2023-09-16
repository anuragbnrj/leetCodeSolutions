
class Solution {
public:
    long long minimumPossibleSum(int n, int target) {
        // // cout << "============================" << endl;
        // long long mid = target / 2;
        // int size = 0;
        // long long sum = 0;
        // int mod = 1000000007;

        // // cout << "mid: " << mid << "\t size: " << size << endl;
        
        // mid = min(mid, (long long) n);
        // sum = (mid * (mid + 1));
        
        // if (mid < n) {
        //     // cout << "hello inside mid" << endl;
            
        //     long long y = target + (n - mid) - 1;
        //     long long x = target - 1;
        //     long long num = 0;
            
        //     // cout << "mid: " << mid << "\t x: " << x << "\t y: " << y << endl;
        //     num = ( ((y * (y + 1))) - ((x * (x + 1))) );
            
        //     // num = num / 2;
            
        //     sum = (sum + num) ;
        // }
        
        // return (sum / 2) % mod;
 
        int size = n;
        long long sum = 0;
        int mod = 1000000007;

        int mid = target / 2;
        for (int i = 1; i <= mid && size > 0; i++, size--) {
            sum = (sum + i);
        }
        
        int curr = target;
        while (size) {
            sum = (sum + curr);
            curr++;
            size--;
        }
        
        return (sum % mod);
    }
};