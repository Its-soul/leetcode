class Solution {
    static int [] dis;
    static int [] subtree;
    static int [] ans;
    static int N;
    static List<Integer> [] tree;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N=n;
        tree= new ArrayList[n];
        dis= new int [n];
        subtree= new int[n];
        ans= new int [n];
        for(int i=0; i<n; i++){
            tree[i]= new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            int u= edges[i][0];
            int v= edges[i][1];
            tree[u].add(v);
            tree[v].add(u);
        }
        Arrays.fill(subtree, 1);
        dfs(0,-1);
        ans[0]= dis[0];
        reRoot(0,-1);
        return ans;

    }

    public static void dfs(int node, int parent){
        for(int child:tree[node]){
            if(child==parent) continue;
            dfs(child, node);
            subtree[node]+= subtree[child];
            dis[node]+=dis[child]+subtree[child];
        }
    }

    public static void reRoot(int node, int parent){
        for(int child: tree[node]){
            if(child==parent) continue;
            ans[child]= ans[node]+ N- 2*subtree[child];
            reRoot(child, node);
        }
    }
}