import math

class Solution:
    '''
        The idea is to manipulate the left side of the first array and then take the resulting k - n elements from the
        second array and ensure that the max of the lefts are all less than the min the rights
        You basically just want to binary search the correct cutoff for the first array which will also result in the correct         cutoff for the second array
    '''
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A, B = nums1, nums2
        if len(B) < len(A):
            A, B = B, A
        total_length = len(nums1) + len(nums2)
        k = total_length//2
        l, r = 0, len(A) - 1
        
        while True:
            i = (l + r)//2
            j = k - i - 2
            
            Aleft = A[i] if i >= 0 else -math.inf
            Aright = A[i + 1] if (i + 1) < len(A) else math.inf
            Bleft = B[j] if j >= 0 else -math.inf
            Bright = B[j + 1] if (j + 1) < len(B) else math.inf
            
            if Aleft <= Bright and Bleft <= Aright:
                if total_length % 2:
                    return min(Aright, Bright)
                return (max(Aleft, Bleft) + min(Aright, Bright)) / 2
            elif Aleft > Bright:
                r = i - 1
            else:
                l = i + 1