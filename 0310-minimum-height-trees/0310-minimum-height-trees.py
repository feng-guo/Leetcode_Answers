from collections import defaultdict

class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        edge_map = defaultdict(set)
        
        for edge in edges:
            edge_map[edge[0]].add(edge[1])
            edge_map[edge[1]].add(edge[0])
        
        prev = {}
        best = {}
        best1 = {}
        
        def dfs(node, current_height):
            for edge in edge_map[node]:
                if node not in prev or prev[node] != edge:
                    prev[edge] = node
                    largest_height = dfs(edge, current_height+1)
                    dist = largest_height - current_height
                    if node not in best:
                        best[node] = (dist, edge)
                    elif dist >= best[node][0]:
                        best1[node] = best[node]
                        best[node] = (dist, edge)
                    elif node not in best1 or best[node][0] > dist > best1[node][0]:
                        best1[node] = (dist, edge)
            
            res = current_height
            if node in best:
                res = current_height + best[node][0]
            else:
                best[node] = (0, None)
            return res
        
        def calculate(node, parent_path_length):
            for edge in edge_map[node]:
                if node not in prev or prev[node] != edge:
                    if best[node][0] > parent_path_length and best[node][1] != edge:
                        calculate(edge, best[node][0] + 1)
                    elif parent_path_length >= best[node][0] or node not in best1 or parent_path_length >= best1[node][0]:
                        calculate(edge, parent_path_length+1)
                    else:
                        calculate(edge, best1[node][0] + 1)
            
            prev_node = None
            if node in prev:
                prev_node = prev[node]
            
            if parent_path_length > best[node][0]:
                best[node] = (parent_path_length, prev_node)
        
        dfs(0, 0)
        calculate(0, 0)
        
        
        
        
        
        res = []
        min_height = float('inf')
        for i in range(n):
            if best[i][0] < min_height:
                res = [i]
                min_height = best[i][0]
            elif best[i][0] == min_height:
                res.append(i)
        
        return res