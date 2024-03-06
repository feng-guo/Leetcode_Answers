class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        visited = {}
        
        def dfs(i, prev):
            visited[i] = not prev
            for vertex in graph[i]:
                if vertex in visited and visited[vertex] != prev:
                    return False
                if vertex not in visited and not dfs(vertex, not prev):
                    return False
                    
            return True
                
        
        for i in range(len(graph)):
            if i not in visited and not dfs(i, True):
                return False
        return True
        