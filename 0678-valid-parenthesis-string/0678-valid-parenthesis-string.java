class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                low++;
                high++;
            }else if(s.charAt(i) == ')'){
                low--;
                high--;
            }else{
                low--;
                high++;
            }

            if(high < 0){
                return false;
            }

            if(low < 0){
                low = 0;
            }
        }

        return low == 0;
    }
}


// class Solution {
//     public boolean checkValidString(String s) {

//         int n = s.length();
//         int end = 0;
//         int start = 0;

//         for(int i=0; i<n; i++){
//             if(s.charAt(i) == '('){
//                 end++;

//             }
//             else if(s.charAt(i) == '*'){
//                 start++;

//             }
//             else {
//                 if(end != 0){
//                     end--;

//                 }
//                 else if(start != 0){
//                     start--;

//                 }
//                 else {
//                     return false;
//                 }
//             }
//         }
//         return start >= end;
//     }
// }