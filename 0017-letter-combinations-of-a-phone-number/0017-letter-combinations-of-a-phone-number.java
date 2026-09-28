class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] mapping = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, "", result, mapping);

        return result;
    }

    private void backtrack(
            String digits,
            int index,
            String current,
            List<String> result,
            String[] mapping) {

        // Base case
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // Current digit ki letters
        String letters = mapping[digits.charAt(index) - '0'];

        // Har letter ko try karo
        for (char ch : letters.toCharArray()) {

            // Choose
            current += ch;

            // Explore
            backtrack(digits, index + 1, current, result, mapping);

            // Undo / Backtrack
            current = current.substring(0, current.length() - 1);
        }
    }
}