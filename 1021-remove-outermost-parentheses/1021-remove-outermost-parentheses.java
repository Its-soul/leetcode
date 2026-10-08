class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count =0;
        for (int i=0 ; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                count--; 
            }
            if (count !=0){
                ans.append(s.charAt(i));
            }
            if(s.charAt(i) == '('){
                count++;
            }


        }
        return ans.toString();
    }
}