class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        inc = start 
        dec = start - 1

        while dec >= 0 or inc < len(nums):
            if inc < len(nums) and nums[inc] == target:
                return abs(inc - start)
        
            if dec >= 0 and nums[dec] == target:
                return abs(start - dec)

            inc += 1
            dec -= 1

        
        return start