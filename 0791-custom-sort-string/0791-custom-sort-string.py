from collections import OrderedDict

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        sort = OrderedDict()
        for c in order:
            sort[c] = 0
        for c in s:
            if c in sort:
                sort[c] += 1
            else:
                sort[c] = 1
        res = []
        for c in sort:
            res = res + [c for _ in range(sort[c])]
        return "".join(res)