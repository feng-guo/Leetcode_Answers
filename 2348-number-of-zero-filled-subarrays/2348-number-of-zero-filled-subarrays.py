class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        sequences = []
        current_sum = 0
        for num in nums:
            if num != 0:
                if current_sum != 0:
                    sequences.append(current_sum)
                current_sum = 0
            else:
                current_sum += 1
        if current_sum != 0:
            sequences.append(current_sum)
        
        total_sum = 0
        for total in sequences:
            total_sum += (total*(total+1))//2
        
        return total_sum
        