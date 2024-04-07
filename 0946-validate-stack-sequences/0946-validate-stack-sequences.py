class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        popped_index = 0
        stack = []
        numbers = set()
        for num in pushed:
            stack.append(num)
            numbers.add(num)
            while popped_index < len(popped) and popped[popped_index] in numbers:
                res = stack.pop()
                if res == popped[popped_index]:
                    popped_index += 1
                else:
                    return False
        
        return popped_index == len(popped)
                
        
        