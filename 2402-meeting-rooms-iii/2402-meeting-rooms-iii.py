import math

class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        in_use = [] ##meetings that are happening (end, room)
        free = [] ##empty meeting rooms
        
        room_dict = {}
        for room in range(n):
            room_dict[room] = 0
            heappush(free, room)
        
        meetings.sort()
        
        for meeting in meetings:
            while len(in_use) > 0 and in_use[0][0] <= meeting[0]:
                freed = heappop(in_use)
                heappush(free, freed[1]) ##add meeting room number to the list of free rooms
            
            if len(free) > 0:
                room = heappop(free)
                heappush(in_use, (meeting[1], room))
                room_dict[room] += 1
            else:
                ##need to wait and boot the next one
                kicked = heappop(in_use)
                room = kicked[1]
                diff = kicked[0] - meeting[0]
                heappush(in_use, (meeting[1] + diff, room))
                room_dict[room] += 1
                
        
        
        
        count = 0
        res = math.inf
        print(room_dict)
        for room in room_dict:
            if (room_dict[room] > count):
                count = room_dict[room]
                res = room
                
        
        return res