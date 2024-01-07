class Solution {
public:
    int maximumSetSize(vector<int>& nums1, vector<int>& nums2) {
        int len = nums1.size();
        set<int> set1(nums1.begin(), nums1.end());
        set<int> set2(nums2.begin(), nums2.end());
        
        // Create a set to store the intersection
        std::set<int> intersection;

        // Use std::set_intersection
        std::set_intersection(
            set1.begin(), set1.end(),
            set2.begin(), set2.end(),
            std::inserter(intersection, intersection.begin())
        );
        
        int interSize = intersection.size();
        set<int> res;

        int sz1 = 0;
        for (int el : set1) {
            if (sz1 == (len / 2)) {
                break;
            }
            if (intersection.count(el) == 0) {
                res.insert(el);
                sz1++;
            }
        }
        for (int el : intersection) {
            if (sz1 == (len / 2)) {
                break;
            }
            res.insert(el);
            sz1++;
        }


        int sz2 = 0;
        for (int el : set2) {
            if (sz2 == (len / 2)) {
                break;
            }
            if (intersection.count(el) == 0) {
                res.insert(el);
                sz2++;
            }
        }
        for (int el : intersection) {
            if (sz2 == (len / 2)) {
                break;
            }

            if (res.count(el) == 0) {
                res.insert(el);
                sz2++;
            }
            
        }

        return res.size(); 
    }
};