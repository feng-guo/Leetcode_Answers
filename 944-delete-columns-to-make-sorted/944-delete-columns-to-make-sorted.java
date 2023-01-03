class Solution {
    public int minDeletionSize(String[] strs) {
        // char[][] matrix = new char[strs.length][strs[0].length()];
        // for (int i=0; i<strs.length; i++) {
        //     for (int j=0; j<strs[0].length(); j++) {
        //         matrix[i] = strs[i].toCharArray();
        //     }
        // }
        int count = 0;
        for (int j=0; j<strs[0].length(); j++) {
            for (int i=1; i<strs.length; i++) {
                if (strs[i].charAt(j) < strs[i-1].charAt(j)) {
                    count++;
                    break;
                }   
            }
        }
        
        return count;
    }
}