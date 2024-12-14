class Solution:
    def continuousSubarrays(self, nums: List[int]) -> int:
        # Monotonic deque to track maximum and minimum elements
        max_q = deque()
        min_q = deque()
        left = 0
        count = 0

        for right, num in enumerate(nums):
            # Maintain decreasing monotonic deque for maximum values
            while max_q and nums[max_q[-1]] < num:
                max_q.pop()
            max_q.append(right)

            # Maintain increasing monotonic deque for minimum values
            while min_q and nums[min_q[-1]] > num:
                min_q.pop()
            min_q.append(right)

            # Shrink window if max-min difference exceeds 2
            while max_q and min_q and nums[max_q[0]] - nums[min_q[0]] > 2:
                # Move left pointer past the element that breaks the condition
                if max_q[0] < min_q[0]:
                    left = max_q[0] + 1
                    max_q.popleft()
                else:
                    left = min_q[0] + 1
                    min_q.popleft()

            # Add count of all valid subarrays ending at current right pointer
            count += right - left + 1

        return count