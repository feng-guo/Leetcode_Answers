class Solution:
    def gridGame(self, grid: List[List[int]]) -> int:
        top_sum = sum(grid[0])
        bot_sum = sum(grid[1])
        top_prefix_sum = []
        bot_prefix_sum = []
        current_top = 0
        current_bot = 0
        for i in range(len(grid[0])):
            current_top += grid[0][i]
            top_prefix_sum.append(current_top)
            bot_prefix_sum.append(bot_sum - current_bot)
            current_bot += grid[1][i]
        
        res = float('inf')
        
        for i in range(len(grid[0])):
            remaining_top = top_sum - top_prefix_sum[i]
            remaining_bot = bot_sum - bot_prefix_sum[i]
            res = min(res, max(remaining_top, remaining_bot))
        
        return res
            