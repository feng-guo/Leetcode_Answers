class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain: cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.parseInt(split[0]);
            String[] domains = split[1].split("\\.");
            String current = "";
            for (int i=domains.length-1; i>-1; i--) {
                if (current.equals("")) {
                    current += domains[i];
                } else {
                    current = domains[i] + "." + current;
                }
                if (map.containsKey(current)) {
                    map.put(current, map.get(current) + count);
                } else {
                    map.put(current, count);
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        for (String key: map.keySet()) {
            res.add(map.get(key) + " " + key);
        }
        
        return res;
    }
}