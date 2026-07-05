class Solution {
    public int maxProfit(int[] prices) {
        int mini = Integer.MAX_VALUE;
        int profit = 0;
        for(int num : prices){
            mini = Math.min(num , mini);
            profit = Math.max(profit , num-mini);
        }
        return profit;
    }
}