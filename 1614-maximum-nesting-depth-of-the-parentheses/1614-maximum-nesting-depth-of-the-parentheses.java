class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                brackets.push(c);
                maxDepth = Math.max(maxDepth, brackets.size());
            } else if (c == ')') {
                brackets.pop();
            }
        }

        return maxDepth;
    }
}