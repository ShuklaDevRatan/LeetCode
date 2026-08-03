class Solution {
    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            if (map.containsKey(a)) {
                if (map.get(a) != b)
                    return false;
            } else {
                if (used.contains(b))
                    return false;

                map.put(a, b);
                used.add(b);
            }
        }

        return true;
    }
}