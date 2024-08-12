class Solution:
    def arrayStringsAreEqual(self, word1: List[str], word2: List[str]) -> bool:
        arr_1_i = 0
        arr_2_i = 0
        s_1_i = 0
        s_2_i = 0
        
        while(word1[arr_1_i][s_1_i] == word2[arr_2_i][s_2_i]):
            s_1_i += 1
            s_2_i += 1
            
            if s_1_i == len(word1[arr_1_i]):
                arr_1_i += 1
                s_1_i = 0
            if s_2_i == len(word2[arr_2_i]):
                arr_2_i += 1
                s_2_i = 0
            if arr_1_i == len(word1):
                return arr_2_i == len(word2)
            if arr_2_i == len(word2):
                return False
        
        return False