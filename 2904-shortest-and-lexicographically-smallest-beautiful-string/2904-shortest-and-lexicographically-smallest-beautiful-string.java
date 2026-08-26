class Solution {

    public String shortestBeautifulSubstring(String s, int k) {
        String smallStr = "";
        int oneCnt = 0;
        int left = 0;
        int right = 0;
        int len = s.length();

        while (right < len) {
            char rch = s.charAt(right);

            if (rch == '1') {
                oneCnt++;
            }

            while (oneCnt == k) {
                smallStr = helper(
                    smallStr,
                    s.substring(left, right + 1)
                );
                char lch = s.charAt(left);
                if (lch == '1') {
                    oneCnt--;
                }
                left++;
            }
            right++;
        }
        return smallStr;
    }

    public String helper(String str1, String str2) {
        if (str1.isEmpty()) return str2;

        if (str1.length() > str2.length()) return str2;

        if (str2.length() > str1.length()) return str1;

        if (str1.compareTo(str2) <= 0) {
            return str1;
        }

        return str2;
    }
}