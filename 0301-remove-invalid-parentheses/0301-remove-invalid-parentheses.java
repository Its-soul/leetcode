class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        fwd(s, res, 0, 0);

        return res;
    }

    public void fwd(String s, List<String> res, int lefti, int leftj) {
        int bal = 0;

        for (int i = lefti; i < s.length(); i++) {
            if (s.charAt(i) == '(') bal++;
            if (s.charAt(i) == ')') bal--;

            if (bal >= 0) continue;

            for (int j = leftj; j <= i; j++)
                if (s.charAt(j) == ')' && (j == leftj || s.charAt(j - 1) != ')'))
                    fwd(s.substring(0, j) + s.substring(j + 1), res, i, j);

            return;
        }

        bwd(s, res, s.length() - 1, s.length() - 1);
    }

    public void bwd(String s, List<String> res, int righti, int rightj) {
        int bal = 0;

        for (int i = righti; i >= 0; i--) {
            if (s.charAt(i) == ')') bal++;
            if (s.charAt(i) == '(') bal--;

            if (bal >= 0) continue;

            for (int j = rightj; j >= i; j--)
                if (s.charAt(j) == '(' && (j == rightj || s.charAt(j + 1) != '('))
                    bwd(s.substring(0, j) + s.substring(j + 1), res, i - 1, j - 1);

            return;
        }

        res.add(s);
    }
}