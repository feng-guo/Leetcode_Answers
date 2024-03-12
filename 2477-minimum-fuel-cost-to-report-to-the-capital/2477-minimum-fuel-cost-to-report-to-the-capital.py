from collections import defaultdict

class Solution:
    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        edges = defaultdict(set)
        for road in roads:
            edges[road[0]].add(road[1])
            edges[road[1]].add(road[0])
        
        def calc_cost(node, prev):
            ## returns cost from node to prev and the number of children from node to prev
            
            cost = 0
            children = 0
            for child in edges[node]:
                if child == prev:
                    continue
                child_cost, child_children = calc_cost(child, node)
                cost += child_cost
                children += child_children
                
            if prev is not None:
                children += 1
                cost += int(ceil(children/seats))
            return cost, children
        
        return calc_cost(0, None)[0]