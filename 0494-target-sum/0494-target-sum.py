class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        dp = {}
        
        def dfs(current, index):
            num = nums[index]
            if index == len(nums)-1:
                count = 0
                if num == current:
                    count += 1
                if num == -current:
                    count += 1
                return count
            if (current, index) in dp:
                return dp[(current, index)]
            else:
                count = dfs(current+num, index+1)
                count += dfs(current-num, index+1)
                dp[(current, index)] = count
                return count
            
        return dfs(target, 0)
        