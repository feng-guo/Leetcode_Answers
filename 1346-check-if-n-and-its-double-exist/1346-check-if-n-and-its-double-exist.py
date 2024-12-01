class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        exist = set()
        for i in arr:
            if i*2 in exist or (i%2==0 and i//2 in exist):
                return True
            exist.add(i)
        
        return False