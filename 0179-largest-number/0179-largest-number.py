class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        nums_s = [str(num) for num in nums]
        nums_s.sort(key=functools.cmp_to_key(lambda a, b: int(b + a) - int(a + b)))
        res = "".join(nums_s)
        if int(res) == 0:
            return "0"
        else:
            return res