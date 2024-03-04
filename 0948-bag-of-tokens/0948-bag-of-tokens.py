class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        tokens.sort()
        left = 0
        right = len(tokens) - 1
        score = 0
        while left <= right:
            if power >= tokens[left]:
                power -= tokens[left]
                left += 1
                score += 1
            else:
                if score > 0 and left != right:
                    power += tokens[right]
                    score -= 1
                    right -= 1
                else:
                    return score
        
        return score