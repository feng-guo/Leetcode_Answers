class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> required = new HashMap<>();
        Map<Integer, Set<Integer>> prereqs = new HashMap<>();
        Set<Integer> taken = new HashSet<>();
        
        for (int[] pr: prerequisites) {
            if (prereqs.containsKey(pr[1])) {
                prereqs.get(pr[1]).add(pr[0]);
            } else {
                Set<Integer> sub = new HashSet<>();
                sub.add(pr[0]);
                prereqs.put(pr[1], sub);
            }
            if (required.containsKey(pr[0])) {
                required.get(pr[0]).add(pr[1]);
            } else {
                Set<Integer> prs = new HashSet<>();
                prs.add(pr[1]);
                required.put(pr[0], prs);
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i=0; i<numCourses; i++) {
            if (!required.containsKey(i)) {
                q.add(i);
                taken.add(i);
            }
        }
        
        while (q.size() > 0) {
            int course = q.poll();
            if (prereqs.containsKey(course)) {
                for (Integer sub: prereqs.get(course)) {
                    Set<Integer> r = required.get(sub);
                    r.remove(course);
                    if(r.size()==0) {
                        required.remove(sub);
                        taken.add(sub);
                        q.add(sub);
                    }
                }
            }
        }
        
        return taken.size() == numCourses;
    }
}