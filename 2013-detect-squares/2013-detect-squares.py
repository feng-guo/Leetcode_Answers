from collections import defaultdict
class DetectSquares:

    def __init__(self):
        self.point_map = DefaultDict(int)
        self.point_set = set()

    def add(self, point: List[int]) -> None:
        x, y = point
        point = (x, y)
        self.point_map[point] += 1
        self.point_set.add(point)

    def count(self, point: List[int]) -> int:
        point_map = self.point_map
        point_set = self.point_set
        x, y = point
        count = 0
        for p in point_set:
            i, j = p
            if abs(x - i) == abs(y - j) and x != i and y != j:
                count += point_map[(i, j)] * point_map[(i, y)] * point_map[(x, j)]
        
        return count
        


# Your DetectSquares object will be instantiated and called as such:
# obj = DetectSquares()
# param_2 = obj.count(point)