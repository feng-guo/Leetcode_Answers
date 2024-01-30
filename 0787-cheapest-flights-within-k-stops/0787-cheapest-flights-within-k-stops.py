from collections import defaultdict
import math

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        flight_map = defaultdict(list)
        visited_map = defaultdict(dict)
        
        cheapest = math.inf
        
        for flight in flights:
            source, dest, cost = flight
            flight_map[source].append([dest, cost])
        
        queue = [[src, 0, 0]]
        visited_map[src][0] = 0
        
        while len(queue) > 0:
            current, current_cost, hops = queue.pop(0)
            if (current_cost > visited_map[current][hops]):
                continue
            next_hop = hops + 1
            if (next_hop > k + 1):
                continue
            for flight in flight_map[current]:
                dest, cost = flight
                next_cost = current_cost + cost
                if dest == src:
                    continue
                if dest == dst:
                    cheapest = min(cheapest, next_cost)
                    continue
                if next_hop not in visited_map[dest].keys() or next_cost < visited_map[dest][next_hop]:
                    visited_map[dest][next_hop] = next_cost
                    queue.append([dest, next_cost, next_hop])
                
        
        
        if cheapest == math.inf:
            return -1
        return cheapest
        
        