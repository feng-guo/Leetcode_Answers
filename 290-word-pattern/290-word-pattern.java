class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        String[] arr = s.split(" ");
        if (arr.length != pattern.length()) {
            return false;
        }
        for (int i=0; i<pattern.length(); i++) {
            char t = pattern.charAt(i);
            if ((map.containsKey(t) && !map.get(t).equals(arr[i])) || (map2.containsKey(arr[i]) && map2.get(arr[i]) != t)) {
                return false;
            } else if (!map.containsKey(t)) {
                map.put(t, arr[i]);
                map2.put(arr[i], t);
            }
        }
        return true;
    }
}