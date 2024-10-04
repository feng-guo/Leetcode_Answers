from collections import defaultdict

class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        total = sum(skill)
        per_team = 2*total / len(skill)
        skill_map = defaultdict(int)
        for s in skill:
            skill_map[s] += 1
        
        count = 0
        for s in skill_map:
            if skill_map[s] != skill_map[per_team - s]:
                return -1
            count += int(s * (per_team-s) * skill_map[s])
        
        return int(count / 2)
        
        