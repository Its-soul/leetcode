class Solution {
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits == null || digits.length() == 0) return ans;

        helper(digits, 0, "", ans);
        return ans;        
    }

    private void helper(String digits, int index, String curr, List<String> ans) {
        if (index == digits.length()) {
            ans.add(curr);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            helper(digits, index + 1, curr + c, ans);
        }
    }
}
