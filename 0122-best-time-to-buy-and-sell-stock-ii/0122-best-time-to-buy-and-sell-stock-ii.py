class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_price = float('inf')
        profit = 0
        for i, price in enumerate(prices):
            if i != 0 and prices[i-1] > price:
                ##Need to sell off
                if min_price < prices[i-1]:
                    profit += prices[i-1] - min_price
                min_price = price
            else:
                min_price = min(price, min_price)
        if min_price < prices[-1]:
            profit += prices[-1] - min_price
        
        return profit
        