class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // Initially, every cell is empty
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, n);

        return result;
    }

    private void solve(int row, char[][] board, int n) {

        // All rows are successfully filled
        if (row == n) {
            result.add(createBoard(board));
            return;
        }

        // Try placing queen in every column of current row
        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, board, n)) {

                // Place queen
                board[row][col] = 'Q';

                // Move to next row
                solve(row + 1, board, n);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> createBoard(char[][] board) {

        List<String> currentBoard = new ArrayList<>();

        for (char[] row : board) {
            currentBoard.add(new String(row));
        }

        return currentBoard;
    }
}