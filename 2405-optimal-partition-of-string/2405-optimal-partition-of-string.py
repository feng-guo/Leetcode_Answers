class Solution:
    def partitionString(self, s: str) -> int:
        last_letter_index = {}
        last_partition = -1
        partitions = 1
        for i, c in enumerate(s):
            if c in last_letter_index:
                if last_letter_index[c] > last_partition:
                    last_partition = i - 1
                    partitions += 1
                
            last_letter_index[c] = i
            
        
        return partitions
        