class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        obstacles_s = set()
        
        def left(d):
            if d == 'n':
                return 'w'
            elif d == 'w':
                return 's'
            elif d == 's':
                return 'e'
            else:
                return 'n'
        
        def right(d):
            if d == 'n':
                return 'e'
            elif d == 'w':
                return 'n'
            elif d == 's':
                return 'w'
            else:
                return 's'
        
        def move(x, y, d, k):
            new_x, new_y = x, y
            if d == 'n':
                for i in range(k):
                    if (new_x, new_y+1) in obstacles_s:
                        return new_x, new_y
                    else:
                        new_y += 1
            elif d == 'e':
                for i in range(k):
                    if (new_x+1, new_y) in obstacles_s:
                        return new_x, new_y
                    else:
                        new_x += 1
            elif d == 's':
                for i in range(k):
                    if (new_x, new_y-1) in obstacles_s:
                        return new_x, new_y
                    else:
                        new_y -= 1
            else:
                for i in range(k):
                    if (new_x-1, new_y) in obstacles_s:
                        return new_x, new_y
                    else:
                        new_x -= 1
            
            return new_x, new_y
        
        def distance(x, y):
            return x**2 + y**2
        
        for obstacle in obstacles:
            obstacles_s.add((obstacle[0], obstacle[1]))
        
        direction = 'n'
        x, y = 0, 0
        best = 0
        
        for command in commands:
            if command == -1:
                direction = right(direction)
            elif command == -2:
                direction = left(direction)
            else:
                x, y = move(x, y, direction, command)
                best = max(best, distance(x, y))
        
        return best