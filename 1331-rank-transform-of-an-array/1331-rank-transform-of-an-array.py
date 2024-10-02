class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        sorted_list = sorted(list(set(arr)))
        
        e_to_rank_map = {}
        
        for i in range(len(sorted_list)):
            e_to_rank_map[sorted_list[i]] = i+1
        
        return [e_to_rank_map[e] for e in arr]