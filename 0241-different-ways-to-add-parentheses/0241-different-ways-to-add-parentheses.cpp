class Solution {
public:
    vector<int> diffWaysToCompute(string expression) {
        int len = expression.size();
        vector<string> arr;

        string temp = "";
        for (int i = 0; i < len; i++) {
            char ch = expression[i];
            if (ch == '+' || ch == '-' || ch == '*') {
                arr.push_back(temp);
                temp = "";
                temp += ch;
                arr.push_back(temp);
                temp = "";
            } else {
                temp += ch;
            }
        }
        arr.push_back(temp);

        // for (int i = 0; i < arr.size(); i++) {
        //     cout << arr[i] << "\t";
        // }
        // cout << endl;

        vector<int> res = solve(0, arr.size() - 1, arr);

        return res;
    }

private:
    vector<int> solve(int beg, int end, vector<string> arr) {
        if (beg == end) {
            return {stoi(arr[beg])};
        }

        vector<int> res;
        for (int i = beg; i <= end; i++) {
            if(arr[i] == "+" || arr[i] == "-" || arr[i] == "*") {
                vector<int> lefVals = solve(beg, i - 1, arr);
                vector<int> rigVals = solve(i + 1, end, arr);

                for (int j = 0; j < lefVals.size(); j++) {
                    for (int k = 0; k < rigVals.size(); k++) {
                        if (arr[i] == "+") {
                            res.push_back(lefVals[j] + rigVals[k]);
                        } else if (arr[i] == "-") {
                            res.push_back(lefVals[j] - rigVals[k]);
                        } else {
                            res.push_back(lefVals[j] * rigVals[k]);
                        }
                    }
                }
            }
        }

        return res;
    }
};