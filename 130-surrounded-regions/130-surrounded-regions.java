class Solution {
    public void solve(char[][] board) {
        char[][] new_board = new char[board.length][board[0].length];
        for (int i=0; i<board.length;i++) {
            for (int j=0; j<board[0].length; j++) {
                new_board[i][j] =  board[i][j];
            }
        }
        
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (new_board[i][j] == 'O' && (i==0 || j==0 || j==board[0].length-1 || i==board.length-1)) {
                    flip(new_board, i, j);
                }
            }
        }
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == 'O' && new_board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    public void flip(char[][] board, int x, int y) {
        if (!(x < 0 || y < 0 || x > board.length-1 || y > board[0].length-1) && board[x][y] == 'O') {
            board[x][y] = 'X';
            flip(board, x-1, y);
            flip(board, x+1, y);
            flip(board, x, y-1);
            flip(board, x, y+1);
        }
    }
}