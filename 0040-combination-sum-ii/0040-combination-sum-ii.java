class Solution {
    public List<List<Integer>> combinationSum2(int[] c, int target) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(c);
        helper(list, new ArrayList<Integer>(), c, target, 0);
        return list;
    }

    public void helper(List<List<Integer>> list, List<Integer> temp, int[] c, int rem, int start) {  
    if(rem < 0) return; 
    else if(rem == 0) list.add(new ArrayList<>(temp));
    else{
        for (int i = start; i < c.length; i++) {
            if(i > start && c[i] == c[i-1]) continue; 
            temp.add(c[i]);
            helper(list, temp, c, rem - c[i], i+1);
            temp.remove(temp.size() - 1);
            }
        }
    }
}