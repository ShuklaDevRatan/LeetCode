class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int need = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                need += 2;

                if (need % 2 == 1) {
                    insertions++;
                    need--;
                }
            } else {
                need--;

                if (need < 0) {
                    insertions++;
                    need = 1;
                }
            }
        }

        return insertions + need;
    }
}

