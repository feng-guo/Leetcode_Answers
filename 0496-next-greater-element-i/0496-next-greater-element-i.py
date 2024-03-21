class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = []
        for num in nums1:
            num_found = False
            num_added = False
            for n in nums2:
                if n == num:
                    num_found = True
                elif num_found and n > num:
                    res.append(n)
                    num_added = True
                    break
            if not num_added:
                res.append(-1)
        
        return res
        
        
        