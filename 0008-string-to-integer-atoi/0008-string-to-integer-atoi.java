class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.isEmpty())return 0;
        if(s.length()== 0) return 0;
        int sign= 1;
        int i= 0;
        if(s.charAt(0)== '-') {
            sign= -1;
            i++;
        } 
        else if (s.charAt(0)== '+') {
            i++;
        }
        String num= "";
        boolean flag= false;
        while (i<s.length() && Character.isDigit(s.charAt(i))) {
            if(s.charAt(i)!='0'){
                flag=true;
            }
            if(flag){
                num+= s.charAt(i);
            }
            i++;
        }
        if(num.equals(""))return 0;
        if(num.length()>=11 && sign==1) return Integer.MAX_VALUE;
        if(num.length()>=11 && sign==-1) return Integer.MIN_VALUE;
        long value = Long.parseLong(num);
        if (sign * value > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (sign * value < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int)(sign * value);
    }
}