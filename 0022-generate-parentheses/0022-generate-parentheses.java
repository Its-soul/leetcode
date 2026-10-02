class Solution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate("", 0, 0, n);
        return res;
    }

    public void generate(String curr, int start, int end, int n){
        if(curr.length()==2*n){
            res.add(curr);
            return;
        }
        if(start<n){
            curr+='(';
            generate(curr, start+1, end, n);
            curr = curr.substring(0, curr.length()-1);
        }
        if(end<start){
            curr+=')';
            generate(curr, start, end+1, n);
            curr = curr.substring(0, curr.length()-1);
        }
    }
}