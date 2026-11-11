class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long common = Math.min(need1, need2);

        long pairCost = Math.min(costBoth, cost1 + cost2);

        long remainingCost;

        if (need1 > need2) {
            remainingCost = (long) (need1 - need2) * Math.min(cost1, costBoth);
        } else {
            remainingCost = (long) (need2 - need1) * Math.min(cost2, costBoth);
        }

        return common * pairCost + remainingCost;
    }
}