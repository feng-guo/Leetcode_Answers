class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        current_sum = 0
        count = 0
        
        for i, num in enumerate(arr):
            if i >= k:
                current_sum -= arr[i-k]
            current_sum += num
            if i >= k-1 and (current_sum/k) >= threshold:
                count += 1
        
        return count