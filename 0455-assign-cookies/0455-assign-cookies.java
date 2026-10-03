class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // child pointer
        int j = 0; // cookie pointer
        int count = 0;

        while (i < g.length && j < s.length) {

            if (s[j] >= g[i]) {
                // Current cookie child ko satisfy kar sakti hai
                count++;
                i++;
                j++;
            } else {
                // Cookie chhoti hai, next bigger cookie dekho
                j++;
            }
        }

        return count;
    }
}