using ll = long long;
class Solution {
public:
    bool judgeSquareSum(int c) {
        ll target = c;

        set<ll> squares;
        for (ll i = 0; i * i <= target ; i++) {
            ll sq = i * i;
            ll req = target - sq;

            squares.insert(sq);

            if (squares.find(req) != squares.end()) {
                return true;
            }
        }
        
        return false;
    }
};