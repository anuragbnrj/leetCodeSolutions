class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {\
        reverse(nums1.begin(), nums1.end());
        reverse(nums1.begin() + n, nums1.end());

        for (int i = 0; i < m + n; i++) {
            cout << nums1[i] << "\t";
        } 
        cout << endl;

        int pt1 = n;
        int pt2 = 0;
        int k = 0;

        while (pt1 < m + n && pt2 < n) {
            if (nums1[pt1] < nums2[pt2]) {
                nums1[k] = nums1[pt1];
                k++;
                pt1++;
            } else {
                nums1[k] = nums2[pt2];
                k++;
                pt2++;
            }
        }

        while(pt2 != n) {
            nums1[k] = nums2[pt2];
            k++;
            pt2++;
        }
        
    }
};