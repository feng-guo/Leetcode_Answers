class Solution:
    def addDigits(self, num: int) -> int:
        if num < 10:
            return num
        else:
            count = 0
            while num > 0:
                count += num%10
                num //= 10
            return self.addDigits(count)
        