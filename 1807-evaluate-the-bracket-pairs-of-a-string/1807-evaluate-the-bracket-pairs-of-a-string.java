class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) != '(') {
                result.append(s.charAt(i));
                i++;
            }
            else {
                int j = i + 1;
                while (s.charAt(j) != ')') {
                    j++;
                }
                String key = s.substring(i + 1, j);
                if (map.containsKey(key)) {
                    result.append(map.get(key));
                } else {
                    result.append('?');
                }
                i = j + 1;
            }
        }

        return result.toString();
    }
}