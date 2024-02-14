class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        is_possible = [False, False, False]
        s, t, d = target
        
        for triplet in triplets:
            a, b, c = triplet
            if (a == s and b<=t and c <= d):
                is_possible[0] = True
            if (a <= s and b==t and c <= d):
                is_possible[1] = True
            if (a <= s and b<=t and c == d):
                is_possible[2] = True

        x, y, z = is_possible
        return x and y and z
        