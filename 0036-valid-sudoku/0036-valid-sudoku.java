class Solution {
    public boolean isValidSudoku(char[][] board) {

        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        List<Set<Integer>> boxes = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                int num = board[i][j] - '0';

                int box = (i / 3) * 3 + (j / 3);

                if (rows.get(i).contains(num) ||
                    cols.get(j).contains(num) ||
                    boxes.get(box).contains(num)) {
                    return false;
                }

                rows.get(i).add(num);
                cols.get(j).add(num);
                boxes.get(box).add(num);
            }
        }

        return true;
    }
}