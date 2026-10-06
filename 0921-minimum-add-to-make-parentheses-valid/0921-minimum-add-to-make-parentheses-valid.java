class Solution {
    public int minAddToMakeValid(String s) {

        int open = 0;
        int unmatched = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                open++;
            } 
            else {
                if (open > 0) {
                    open--;
                } 
                else {
                    unmatched++;
                }
            }
        }

        return unmatched + open;
    }
}