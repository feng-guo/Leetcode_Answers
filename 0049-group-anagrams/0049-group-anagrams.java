class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] chars = new char[26];
            for (char c: str.toCharArray()) {
                chars[c-97]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<26;i++) {
                if (chars[i]>0) {
                    sb.append(chars[i]);
                    sb.append((char)(i+97));
                }
            }
            String s = sb.toString();
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for(String s:map.keySet()) {
            list.add(map.get(s));
        }
        return list;
    }
}