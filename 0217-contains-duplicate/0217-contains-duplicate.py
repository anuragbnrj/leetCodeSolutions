class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        item_counts = Counter(nums)

        for key in item_counts:
            val = item_counts[key]

            if val > 1:
                return True

        return False
        