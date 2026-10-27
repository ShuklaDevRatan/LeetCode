class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        for (int i = 0; i < m; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < n; j++) {
                row.append('#');
            }

            grid[i] = row.toString();
        }

        StringBuilder firstRow = new StringBuilder();

        for (int j = 0; j < n; j++) {
            firstRow.append('.');
        }

        grid[0] = firstRow.toString();

        for (int i = 1; i < m; i++) {
            grid[i] = grid[i].substring(0, n - 1) + ".";
        }

        return grid;
    }
}
