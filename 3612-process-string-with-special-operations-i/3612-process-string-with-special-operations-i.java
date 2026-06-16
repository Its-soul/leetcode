class Solution {
    public String processStr(String s) {
        StringBuilder result=new StringBuilder();

        for (char i:s.toCharArray()) {
            if (i=='#') {
                result.append(result.toString());
            }
            else if (i=='*') {
                if (result.length()>0) {
                    result.deleteCharAt(result.length()-1);
                }
            }
            else if (i=='%') {
                result.reverse();
            }
            else {
                result.append(i);
            }
        }
        return result.toString();
    }
}