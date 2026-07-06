class Solution {
    public void rotate(int[][] matrix) {
       int n = matrix.length;
        for(int i = 0; i < n ; i++){
            for(int j = i+1;j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int [] ans : matrix){
            int i = 0 , j = ans.length-1;
            while(i <= j){
                int temp = ans[i];
                ans[i++] = ans[j];
                ans[j--] = temp;
            }
        }
        return;
    }
}