import math

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = {}
        
        
        
        def dfs(c_amount, coin):
            if (c_amount<0):
                return 0
            if (c_amount==0):
                return 1
            
            if (c_amount, coin) in dp:
                return dp[(c_amount, coin)]
            else:
                count = 0
                for x in coins:
                    if (x > coin):
                        continue
                    count += dfs(c_amount-x, x)
                dp[(c_amount, coin)] = count
                return dp[(c_amount, coin)]
        
        return dfs(amount, math.inf)
                    
        