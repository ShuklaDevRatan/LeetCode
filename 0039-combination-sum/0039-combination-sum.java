class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0 , candidates , target , new ArrayList<>() , result );
        return result;
    }


    private void backtrack(int index , int[] candidates , int target , List<Integer>ans , List<List<Integer>> result ) {
        if(index == candidates.length){
            if(target == 0) {
                result.add(new ArrayList<>(ans));
            }
            return;
        }
       if(candidates[index] <= target){
        ans.add(candidates[index]);
        backtrack(index,candidates,target-candidates[index],ans , result );
         ans.remove (ans.size()-1);
       }
         backtrack(index+1,candidates,target ,ans , result );
    }
}