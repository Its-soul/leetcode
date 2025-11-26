class Solution {
    public List<List<Integer>> permute(int[] nums) {
     List<List<Integer>> result= new ArrayList<>();
     helper(result, new ArrayList<>(), nums);
     return result;  
    }
    public void helper(List<List<Integer>> result, List<Integer>path, int[]nums){
        if (path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int num: nums){
            if(path.contains(num)) continue;
            path.add(num);
            helper(result, path, nums);
            path.remove(path.size()-1);
        }
    }
}