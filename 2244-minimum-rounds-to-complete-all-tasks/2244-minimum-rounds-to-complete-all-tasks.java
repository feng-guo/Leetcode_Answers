class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> todo = new HashMap<>();
        Set<Integer> over3 = new HashSet<>();
        int res = 0;
        for (int task: tasks) {
            if (todo.containsKey(task)) {
                todo.put(task, todo.get(task)+1);
                if (todo.get(task) == 3) {
                    todo.remove(task);
                    over3.add(task);
                    res++;
                }
            } else {
                todo.put(task, 1);
            }
        }
        for (int key: todo.keySet()) {
            if (todo.get(key) == 2) {
                res++;
            } else if (over3.contains(key)) {
                res++;
            } else {
                return -1;
            }
        }
        return res;
    }
}