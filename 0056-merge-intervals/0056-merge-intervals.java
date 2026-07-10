class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals , (a,b)-> Integer.compare(a[0],b[0]));
       List<int[]>list = new ArrayList<>();
       
       for(int[] i : intervals){
        if(list.size() == 0 || list.get(list.size()-1)[1] < i[0]){
            list.add(i);
        }else{
            list.get(list.size()-1)[1] = Math.max( list.get(list.size()-1)[1] , i[1]);
        }
       }
        int [][]ans = new int[list.size()][2];
       for(int i = 0 ; i < list.size();i++){
        ans[i] = list.get(i);
       }
       return ans;
    }
}