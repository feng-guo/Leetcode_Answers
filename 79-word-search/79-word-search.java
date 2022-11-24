class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        char[] arr = word.toCharArray();
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (exists(board, visited, arr, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    public boolean exists(char[][] board, boolean[][] visited, char[] word, int x, int y, int index) {
        if (board[x][y] != word[index] || visited[x][y]) {
            return false;
        } else if (index == word.length-1) {
            return true;
        }
        visited[x][y] = true;
        
        if (x != 0 && exists(board, visited, word, x-1, y, index+1)) {
            return true;
        }
        if (x != board.length-1 && exists(board, visited, word, x+1, y, index+1)) {
            return true;
        }
        if (y != 0 && exists(board, visited, word, x, y-1, index+1)) {
            return true;
        }
        if (y != board[0].length-1 && exists(board, visited, word, x, y+1, index+1)) {
            return true;
        }
        
        visited[x][y] = false;
        return false;
    }
}