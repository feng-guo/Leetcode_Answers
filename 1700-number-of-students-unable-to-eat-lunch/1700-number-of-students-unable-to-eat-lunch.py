class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        eat = 0
        while sandwiches:
            if eat == len(students):
                return eat
            sandwich = sandwiches.pop(0)
            current = students.pop(0)
            if current == sandwich:
                eat = 0
            else:
                eat += 1
                students.append(current)
                sandwiches.insert(0, sandwich)
        
        return 0
        