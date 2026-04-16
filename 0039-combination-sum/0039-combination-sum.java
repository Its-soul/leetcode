class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> ans, int[] cand, int target, int idx){
        if(target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(target < 0 || idx >= cand.length) return;
        helper(res,ans,cand,target,idx+1);
        ans.add(cand[idx]);
        helper(res,ans,cand,target-cand[idx],idx);
        ans.remove(ans.size()-1);
    }
}