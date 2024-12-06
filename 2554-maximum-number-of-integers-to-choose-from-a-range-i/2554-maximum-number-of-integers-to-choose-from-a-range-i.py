class Solution:
    def maxCount(self, banned: list[int], n: int, maxSum: int) -> int:
        # Store banned numbers in a set for quick lookup
        banned_set = set(banned)

        count = 0

        # Try each number from 1 to n
        for num in range(1, n + 1):
            # Skip banned numbers
            if num in banned_set:
                continue

            # Return if adding the current number exceeds maxSum
            if maxSum - num < 0:
                return count

            # Include current number
            maxSum -= num
            count += 1

        return count