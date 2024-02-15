from collections import defaultdict, OrderedDict

class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        connections = defaultdict(dict)
        ticket_counter = defaultdict(int)
        res = []
        tickets.sort()
        for ticket in tickets:
            from_i, to_i = ticket
            ticket_tuple = (from_i, to_i)
            ticket_counter[ticket_tuple] += 1
            connections[from_i][to_i] = ""
            
        def dfs(current, visited):
            nonlocal res
            visited.append(current)
            if len(visited) == len(tickets) + 1:
                old_res_str = "".join(res)
                new_res_str = "".join(visited)
                if len(res) == 0 or new_res_str < old_res_str:
                    res = visited.copy()
                return True
            returned = False
            for destination in connections[current]:
                ticket_tuple = (current, destination)
                if ticket_counter[ticket_tuple] > 0:
                    ticket_counter[ticket_tuple] -= 1
                    returned = dfs(destination, visited)
                    ticket_counter[ticket_tuple] += 1
                    visited.pop()
                    if returned:
                        break
            return returned
            
        dfs("JFK", [])
        
        return res
                
            