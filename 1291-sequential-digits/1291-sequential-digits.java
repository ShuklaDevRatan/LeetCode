class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ans = new ArrayList<>();

        String digits = "123456789";

        int startLength = String.valueOf(low).length();
        int endLength = Math.min(String.valueOf(high).length(), 9);

        for (int len = startLength; len <= endLength; len++) {

            for (int i = 0; i <= 9 - len; i++) {

                int num = Integer.parseInt(digits.substring(i, i + len));

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }
}