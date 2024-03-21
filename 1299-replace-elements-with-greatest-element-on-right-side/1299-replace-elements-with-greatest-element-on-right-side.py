class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        max_num_to_right = -1
        for i in range(len(arr)):
            index = len(arr) - 1 - i
            temp = arr[index]
            arr[index] = max_num_to_right
            max_num_to_right = max(max_num_to_right, temp)
        return arr
            