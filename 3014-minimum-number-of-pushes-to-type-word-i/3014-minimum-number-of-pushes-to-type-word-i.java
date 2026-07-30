class Solution {
    public int minimumPushes(String word) {
        int m = word.length();
        int res = 0;
        for(int i = 0; i < m; i++){
            res = res+(i/8+1);
        }
        return res;
    }
}