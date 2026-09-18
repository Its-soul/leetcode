class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int first[] = new int[26];
        int last[] = new int[26];

        Arrays.fill(first, n);

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            first[ch] = Math.min(first[ch], i);
            last[ch] = i;
        }

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        for (int i = 0; i < n; i++) {

            int ch = s.charAt(i) - 'a';

            if (first[ch] != i)
                continue;

            int left = i;
            int right = last[ch];
            boolean valid = true;

            for (int j = left; j <= right; j++) {

                int curr = s.charAt(j) - 'a';

                if (first[curr] < left) {
                    valid = false;
                    break;
                }

                right = Math.max(right, last[curr]);
            }

            if (!valid)
                continue;

            if (left > prevEnd) {
                ans.add(s.substring(left, right + 1));
            } else {
                ans.set(ans.size() - 1, s.substring(left, right + 1));
            }

            prevEnd = right;
        }

        return ans;
    }
}