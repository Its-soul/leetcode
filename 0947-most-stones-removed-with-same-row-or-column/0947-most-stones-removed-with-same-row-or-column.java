class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int [] parent = new int[n];
        int [] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (int i=0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j, parent, rank);
                }
            }
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (find(i, parent) == i) {
                components++;
            }
        }
        return n - components;
    }
    public static int find(int x, int [] parent) {
        if (x==parent[x]) return x;
        return parent[x] = find(parent[x],parent);
    }
    public static void union(int x, int y, int [] parent, int [] rank) {
        int xpar = find(x, parent);
        int ypar = find(y, parent);
        if (xpar == ypar) return;
        if (rank[xpar] < rank[ypar]) {
            parent[xpar] = ypar;
        } else if (rank[xpar] > rank[ypar]) {
            parent[ypar] = xpar;
        } else {
            parent[ypar] = xpar;
            rank[xpar]++;
        }
    }
}