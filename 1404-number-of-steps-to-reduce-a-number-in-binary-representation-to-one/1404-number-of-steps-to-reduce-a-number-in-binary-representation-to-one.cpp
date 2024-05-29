class Solution {
public:
    int numSteps(string s) {
        string temp = s;
        int n = temp.size();

        int steps = 0;
        while (n > 1) {
            // cout << temp << endl;
            if (temp[n - 1] == '1') {
                temp = addOne(temp);
                steps++;
                // cout << "temp adding one: " << temp << endl; 
            }

            temp.pop_back();
            steps++;
            n = temp.size();
        }
        
        return steps;
    }

private:
    string addOne(string number) {
        int n = number.size();

        int carry = 0;
        string res = "";
        for (int i = n - 1; i >= 0; i--) {
            int d1 = number[i] - '0';
            int d2 = i == (n - 1) ? 1 : 0;
            int sum = 0;

            if (carry == 0) {
                if (d1 == 0 && d2 == 0) {
                    sum = 0;
                    carry = 0;
                } else if (d1 == 0 && d2 == 1) {
                    sum = 1;
                    carry = 0;
                } else if (d1 == 1 && d2 == 0) {
                    sum = 1;
                    carry = 0;
                } else if (d1 == 1 && d2 == 1) {
                    sum = 0;
                    carry = 1;
                }
            } else if (carry == 1) {
                if (d1 == 0 && d2 == 0) {
                    sum = 1;
                    carry = 0;
                } else if (d1 == 0 && d2 == 1) {
                    sum = 0;
                    carry = 1;
                } else if (d1 == 1 && d2 == 0) {
                    sum = 0;
                    carry = 1;
                } else if (d1 == 1 && d2 == 1) {
                    sum = 1;
                    carry = 1;
                }
            }

            res += (sum + '0');
        }

        if (carry == 1) {
            res += (carry + '0');
        }

        reverse(res.begin(), res.end());
        return res;
    }
};