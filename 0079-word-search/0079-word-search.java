class Solution {

    public boolean exist(char[][] board, String word) {

        Set<String> visited = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (search(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(
            char[][] board,
            String word,
            int row,
            int col,
            int index,
            Set<String> visited) {

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Already visited
        String cell = row + "," + col;

        if (visited.contains(cell)) {
            return false;
        }

        // Character doesn't match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Last character matched
        if (index == word.length() - 1) {
            return true;
        }

        // Mark current cell as visited
        visited.add(cell);

        // Explore 4 directions
        boolean found =
                search(board, word, row - 1, col, index + 1, visited) || // UP
                search(board, word, row + 1, col, index + 1, visited) || // DOWN
                search(board, word, row, col - 1, index + 1, visited) || // LEFT
                search(board, word, row, col + 1, index + 1, visited);   // RIGHT

        // Backtrack
        visited.remove(cell);

        return found;
    }
}