class Solution {

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        // Initially, every cell is empty
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        return solve(0, board, n);
    }

    private int solve(int row, char[][] board, int n) {

        // All rows are successfully filled
        if (row == n) {
            return 1;
        }

        int count = 0;

        // Try placing queen in every column of current row
        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, board, n)) {

                // Place queen
                board[row][col] = 'Q';

                // Count solutions from next row
                count += solve(row + 1, board, n);

                // Backtrack
                board[row][col] = '.';
            }
        }

        return count;
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
}