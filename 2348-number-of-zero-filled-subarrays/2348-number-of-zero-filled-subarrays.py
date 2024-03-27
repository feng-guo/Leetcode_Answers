class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        current_sum = 0
        total_sum = 0
        for num in nums:
            if num != 0:
                if current_sum != 0:
                    total_sum += (current_sum*(current_sum+1))//2
                current_sum = 0
            else:
                current_sum += 1
        if current_sum != 0:
            total_sum += (current_sum*(current_sum+1))//2
        return total_sum
        