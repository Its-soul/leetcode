class Solution {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parentA= new int[n+1];
        int[] rankA= new int[n+1];

        int[] parentB = new int[n+1];
        int[] rankB= new int[n+1];

        for (int i=1; i<=n; i++) {
            parentA[i]=i;
            parentB[i]=i;
        }
        int compA=n;
        int compB=n;
        int remove=0;

        // type 3
        for (int[] e:edges) {
            if (e[0]==3) {
                boolean a = union(parentA, rankA, e[1], e[2]);
                boolean b = union(parentB, rankB, e[1], e[2]);

                if (a){
                    compA--;
                }
                if (b){
                    compB--;
                }
                if (!a && !b) remove++;
            }
        }
        // type 1
        for (int[] e:edges) {
            if (e[0]==1) {
                if (union(parentA, rankA, e[1], e[2])) compA--;
                else remove++;
            }
        }

        // type 2
        for (int[] e:edges) {
            if (e[0]==2) {
                if (union(parentB, rankB, e[1], e[2])) compB--;
                else remove++;
            }
        }

        if (compA!=1 || compB!=1)
            return -1;

        return remove;
    }

    static int find(int[] parent, int x) {
        if (x ==parent[x])return x;
        return parent[x]=find(parent, parent[x]);
    }

    static boolean union(int[] parent, int[] rank, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);

        if (pa==pb) return false;

        if (rank[pa]<rank[pb]) parent[pa]=pb;
        else if (rank[pa] > rank[pb]) parent[pb]=pa;
        else {
            parent[pb]=pa;
            rank[pa]++;
        }
        return true;
    }

}