class Solution {

    static class SegTree{
        int n; 
        int [] tree;
        public SegTree(int n){
            this.n= n;
            tree= new int[4*n];

        }

        public int query(int node, int left, int right, int queryLeft, int queryRight){
            if(left>queryRight || right<queryLeft){
                return 0;
            }
            if(queryLeft <= left && right<= queryRight){
                return tree[node];
            }

            int mid = (left+right)/2;
            return query(2*node+1, left, mid, queryLeft, queryRight)+query(2*node+2, mid+1, right,  queryLeft, queryRight);
        }

        public void update(int node, int left, int right, int idx){
            if(left==right){
                tree[node]++;
                return;
            }

            int mid = (left+ right)/2;
            if(idx <=mid){
                update(2*node+1, left, mid, idx);
            }
            else{
                update(2*node+2, mid+1, right, idx);
            }
            tree[node] = tree[node*2+1]+tree[2*node+2];
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n= nums.length;
        int [] sorted= nums.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx= 0;

        for(int val: sorted){
            if(!map.containsKey(val)){
                map.put(val, idx++);
            }
        }

        SegTree seg = new SegTree(idx);
        Integer[] ans = new Integer[n];
        for(int i= n-1; i>=0; i--){
            int val = map.get(nums[i]);
            ans[i]= seg.query(0,0,idx-1,0, val-1);
            seg.update(0,0,idx-1, val);
        }
        return Arrays.asList(ans);

    }
}