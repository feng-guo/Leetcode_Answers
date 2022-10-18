public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String encoded = "";
        for (String str: strs) {
            int l = str.length();
            int ones = l%10;
            int tens = (l%100)/10;
            int hundreds= l/100;
            encoded += hundreds + "" + tens + "" + ones + str;
        }
        return encoded;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        while (s.length() > 0) {
            int length = Integer.parseInt(s.substring(0, 3));
            s=s.substring(3);
            list.add(s.substring(0,length));
            s=s.substring(length);
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));