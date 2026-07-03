// class Solution {
//     public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

//         int n= online.length;

//         List<List<int[]>> graph= new ArrayList<>();

//         for(int i=0; i<n; i++){
//             graph.add(new ArrayList<>());
//         }

//         int high= -1;

//         for(int [] edge: edges){

//             int u= edge[0];
//             int v= edge[1];
//             int wt= edge[2];

//             graph.get(u).add(new int[]{v, wt});

//             high= Math.max(high, wt);
//         }

//         int low=0;
//         int ans=-1;

//         while(low<=high){

//             int mid= low+(high-low)/2;

//             if(check(graph, online, mid, k)){
//                 ans= mid;
//                 low= mid+1;
//             }

//             else{
//                 high= mid-1;
//             }
//         }

//         return ans;
//     }

//     public boolean check(List<List<int[]>> graph, boolean[] online, long mid, long k){

//         int n= graph.size();

//         long [] dist= new long[n];
//         Arrays.fill(dist, Long.MAX_VALUE);

//         dist[0]=0;

//         PriorityQueue<long[]> pq= new PriorityQueue<>((a,b)->Long.compare(a[0], b[0]));

//         pq.offer(new long[]{0,0});

//         while(!pq.isEmpty()){

//             long [] curr= pq.poll();

//             long cost= curr[0];
//             int node= (int)curr[1];

//             if(cost>dist[node]){
//                 continue;
//             }

//             if(node!=0 && node!=n-1 && !online[node]){
//                 continue;
//             }

//             for(int [] edge: graph.get(node)){

//                 int adj= edge[0];
//                 int wt= edge[1];

//                 if(wt<mid){
//                     continue;
//                 }

//                 if(adj!=0 && adj!=n-1 && !online[adj]){
//                     continue;
//                 }

//                 long newCost= cost+wt;

//                 if(newCost>k){
//                     continue;
//                 }

//                 if(newCost<dist[adj]){
//                     dist[adj]= newCost;
//                     pq.offer(new long[]{newCost, adj});
//                 }
//             }
//         }
//         return dist[n-1]<=k;
//     }
// }

class Solution {

    List<int[]>[] g;
    long[] dp;
    int n;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        n = online.length;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        int l = Integer.MAX_VALUE;
        int r = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (!online[u] || !online[v]) {
                continue;
            }
            g[u].add(new int[] { v, w });
            l = Math.min(l, w);
            r = Math.max(r, w);
        }

        if (!check(l, k)) {
            return -1;
        }

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(mid, k)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public boolean check(int mid, long k) {
        dp = new long[n];
        Arrays.fill(dp, -1);
        return dfs(0, mid) <= k;
    }

    public long dfs(int u, int mid) {
        if (u == n - 1) {
            return 0;
        }
        if (dp[u] != -1) {
            return dp[u];
        }

        long res = Long.MAX_VALUE / 2;
        for (int[] edge : g[u]) {
            int v = edge[0];
            int w = edge[1];
            if (w >= mid) {
                res = Math.min(res, dfs(v, mid) + w);
            }
        }
        dp[u] = res;
        return res;
    }
}