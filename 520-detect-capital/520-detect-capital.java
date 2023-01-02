import java.util.regex.*;

class Solution {
    public boolean detectCapitalUse(String word) {
        Pattern pattern = Pattern.compile("[A-Z]*|([A-Z]?[a-z]*)");
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }
}