class Solution:
    def bestClosingTime(self, customers: str) -> int:
        n_count = 0
        y_count = 0
        n_list = []
        y_list = []
        
        penalty = float("inf")
        res = 0
        for i, c in enumerate(customers):
            index = len(customers) - 1 - i
            n_list.append(n_count)
            if c == "N":
                n_count += 1
            if customers[index] == "Y":
                y_count += 1
            y_list.append(y_count)
        n_list.append(n_count)
        y_list =  y_list[::-1]
        y_list.append(0)
        
        for i in range(len(customers)+1):
            current_penalty = n_list[i] + y_list[i]
            if current_penalty < penalty:
                penalty = current_penalty
                res = i
        
        return res