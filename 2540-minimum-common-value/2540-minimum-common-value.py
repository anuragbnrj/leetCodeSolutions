class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        return next(iter(sorted(set(nums1) & set(nums2))), -1)
        