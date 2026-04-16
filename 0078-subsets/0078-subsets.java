class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr= new ArrayList<>();
        helper(res, curr, 0, nums);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> curr, int i, int [] nums){
        if(i==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(res, curr, i+1, nums);
        curr.remove(curr.size()-1);
        helper(res, curr, i+1, nums);
    }
}