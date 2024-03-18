class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points = [(point[0], point[1]) for point in points]
        points.sort()
        current = None
        count = 0
        for i, point in enumerate(points):
            
            if not current:
                current = point
            elif current[0] <= point[0] <= current[1]:
                current = [max(current[0], point[0]), min(current[1], point[1])]
            else:
                count += 1
                current = point
            if i == len(points) - 1:
                count += 1
                
        
        return count