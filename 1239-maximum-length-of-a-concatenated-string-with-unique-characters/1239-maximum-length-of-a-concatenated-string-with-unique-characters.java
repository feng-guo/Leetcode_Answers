class Solution {
    int best;
    public int maxLength(List<String> arr) {
        best = 0;
        for (int i=0 ; i<arr.size(); i++) {
            findMax(arr, null, i);
        }
        
        return best;
    }
    
    public void findMax(List<String> arr, Set<Character> set, int start) {
        if (! (start < arr.size())) {
            best = Math.max(set.size(), best);
        } else {
            for (int i=start; i<arr.size(); i++) {
                Set<Character> copy;
                int old_size = 0;
                if (set == null) {
                    copy = new HashSet<>();

                } else {
                    old_size = set.size();
                    copy = new HashSet<>(set);
                }
                for (char c: arr.get(i).toCharArray()) {
                    copy.add(c);  
                }
                if (old_size + arr.get(i).length() == copy.size()) {
                    findMax(arr, copy, i+1);  
                } else if (set != null) {
                    best = Math.max(set.size(), best);
                }
            }
        }
    }
}