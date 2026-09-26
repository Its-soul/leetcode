// class Solution {

//     HashMap<String, String> map = new HashMap<>();

//     public String evaluate(String s, List<List<String>> knowledge) {
//         for (List<String> x : knowledge) {
//             map.put(x.get(0), x.get(1));
//         }

//         return dfs(s);
//     }

//     public String dfs(String s) {
//         int r = s.indexOf(')');

//         if (r == -1) {
//             return s;
//         }

//         int l = s.lastIndexOf('(', r);

//         String left = s.substring(0, l);
//         String key = s.substring(l + 1, r);
//         String right = s.substring(r + 1);

//         String value = map.getOrDefault(key, "?");

//         return dfs(left + value + right);
//     }
// }

class Solution {

    HashMap<String, String> map = new HashMap<>();

    public String evaluate(String s, List<List<String>> knowledge) {
        for (List<String> x : knowledge) {
            map.put(x.get(0), x.get(1));
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int j = s.indexOf(')', i);
                String key = s.substring(i + 1, j);

                ans.append(map.getOrDefault(key, "?"));
                i = j;
            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}