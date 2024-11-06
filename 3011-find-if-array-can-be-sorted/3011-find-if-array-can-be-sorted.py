class Solution:
    def canSortArray(self, nums: List[int]) -> bool:
        
        prev_section_max = 0
        section_min = float('inf')
        section_max = 0
        num_set_bits = 0
        
        for i, num in enumerate(nums):
            curr_num_set_bits = 0
            t_num = num
            while t_num > 0:
                curr_num_set_bits += t_num & 1
                t_num >>= 1
            
            if curr_num_set_bits != num_set_bits:
                if prev_section_max > section_min:
                    return False
                prev_section_max = section_max
                section_max, section_min = num, num
                num_set_bits = curr_num_set_bits
            
            section_max = max(section_max, num)
            section_min = min(section_min, num)
            
            if i == len(nums) - 1:
                if prev_section_max > section_min:
                    return False
        
        return True
        