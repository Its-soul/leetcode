class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] inv) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : inv) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] vis = new boolean[n];
        dfs(adj, k, vis);

        boolean canRemove = true;
        for (int[] edge : inv) {
            int u = edge[0], v = edge[1];
            if (!vis[u] && vis[v]) {
                canRemove = false;
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!canRemove || !vis[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    public void dfs(List<List<Integer>> adj, int u, boolean[] vis) {
        if (vis[u]) return;

        vis[u] = true;
        for (int v : adj.get(u)) {
            dfs(adj, v, vis);
        }
    }
}