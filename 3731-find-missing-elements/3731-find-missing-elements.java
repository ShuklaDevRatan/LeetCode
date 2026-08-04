class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        for(int i = min; i <= max; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }

        return list;
    }
}
