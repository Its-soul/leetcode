// class Solution {
//     public int[] findSubtreeSizes(int[] parent, String s) {
//         int n = parent.length;
//         int[] newParent = parent.clone();
        
//         for (int x = 1; x < n; x++) {
//             int curr = parent[x];
//             while (curr != -1) {
//                 if (s.charAt(curr) == s.charAt(x)) {
//                     newParent[x] = curr;
//                     break;
//                 }
//                 curr = parent[curr];
//             }
//         }
        
//         List<List<Integer>> children = new ArrayList<>();
//         for (int i = 0; i < n; i++) children.add(new ArrayList<>());
//         for (int i = 1; i < n; i++) children.get(newParent[i]).add(i);
        
//         int[] size = new int[n];
//         dfs(0, children, size);
//         return size;
//     }
    
//     public int dfs(int u, List<List<Integer>> children, int[] size) {
//         int total = 1;
//         for (int v : children.get(u)) {
//             total += dfs(v, children, size);
//         }
//         return size[u] = total;
//     }
// }

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> children = new ArrayList<>();
        for (int x = 0; x < n; x++) children.add(new ArrayList<>());
        for (int x = 1; x < n; x++) children.get(parent[x]).add(x);
        
        int[] size = new int[n], above = new int[n], last = new int[26];
        Arrays.fill(size, 1);
        Arrays.fill(last, -1);
        
        Deque<Integer> stack = new ArrayDeque<>(List.of(0));
        while (!stack.isEmpty()) {
            int x = stack.pop();
            if (x >= 0) {
                int c = s.charAt(x) - 'a';
                above[x] = last[c];
                last[c] = x;
                stack.push(~x);
                for (int child : children.get(x)) stack.push(child);
            } else {
                x = ~x;
                last[s.charAt(x) - 'a'] = above[x];
                if (x > 0) {
                    size[above[x] >= 0 ? above[x] : parent[x]] += size[x];
                }
            }
        }
        return size;
    }
}