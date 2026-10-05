// class Solution {
//     public int scoreOfParentheses(String s) {

//         Stack<Integer> st = new Stack<>();
//         st.push(0);

//         for(char ch:s.toCharArray()){

//             if(ch=='('){
//                 st.push(0);
//             }
//             else{
//                 int top=st.pop();
//                 int score;

//                 if(top==0){
//                     score=1;
//                 }
//                 else{
//                     score=2*top;
//                 }
//                 st.push(st.pop()+score);
//             }
//         }

//         return st.pop();
//     }
// }

class Solution {
    public int scoreOfParentheses(String s) {

        int count = 0;
        int score = 0;
        
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }else{
                count--;
                if(s.charAt(i-1)=='('){
                    score+= 1<<count;
                }
            }
        }
        return score;
    }
}