class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n= online.length;

        List<List<int[]>> graph= new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        int high= -1;

        for(int [] edge: edges){

            int u= edge[0];
            int v= edge[1];
            int wt= edge[2];

            graph.get(u).add(new int[]{v, wt});

            high= Math.max(high, wt);
        }

        int low=0;
        int ans=-1;

        while(low<=high){

            int mid= low+(high-low)/2;

            if(check(graph, online, mid, k)){
                ans= mid;
                low= mid+1;
            }

            else{
                high= mid-1;
            }
        }

        return ans;
    }

    public boolean check(List<List<int[]>> graph, boolean[] online, long mid, long k){

        int n= graph.size();

        long [] dist= new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0]=0;

        PriorityQueue<long[]> pq= new PriorityQueue<>((a,b)->Long.compare(a[0], b[0]));

        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){

            long [] curr= pq.poll();

            long cost= curr[0];
            int node= (int)curr[1];

            if(cost>dist[node]){
                continue;
            }

            if(node!=0 && node!=n-1 && !online[node]){
                continue;
            }

            for(int [] edge: graph.get(node)){

                int adj= edge[0];
                int wt= edge[1];

                if(wt<mid){
                    continue;
                }

                if(adj!=0 && adj!=n-1 && !online[adj]){
                    continue;
                }

                long newCost= cost+wt;

                if(newCost>k){
                    continue;
                }

                if(newCost<dist[adj]){
                    dist[adj]= newCost;
                    pq.offer(new long[]{newCost, adj});
                }
            }
        }
        return dist[n-1]<=k;
    }
}