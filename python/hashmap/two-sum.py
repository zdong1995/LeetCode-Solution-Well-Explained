class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        for i in range(0, len(nums)):
            complement = target - nums[i]
            if complement in seen:
                return [i, seen[complement]]
            else:
                seen[nums[i]] = i
        return None