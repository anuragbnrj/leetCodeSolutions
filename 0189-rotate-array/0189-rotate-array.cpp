class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int len = nums.size();

        k = k % len;

        reverseArray(0, len - k - 1, nums);
        reverseArray(len - k, len - 1, nums);
        reverseArray(0, len - 1, nums);
    }

private:
    void reverseArray(int beg, int end, vector<int> &arr) {
        while (beg < end) {
            swap(arr[beg], arr[end]);
            beg++;
            end--;
        }
    }
};