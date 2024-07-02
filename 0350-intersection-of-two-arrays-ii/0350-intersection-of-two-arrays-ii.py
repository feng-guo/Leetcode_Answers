from collections import defaultdict

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        list1 = defaultdict(int)
        for num in nums1:
            list1[num] += 1
        res = []
        for num in nums2:
            if list1[num] > 0:
                list1[num] -= 1
                res.append(num)
        return res