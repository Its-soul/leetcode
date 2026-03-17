class Solution {
    static int [] segTree;
    public int[] leftmostBuildingQueries(int[] arr, int[][] queries) {
        int n= arr.length;
        int [] answer= new int [queries.length];
        segTree= new int [4*n];
        build(arr, 0,0,n-1);
        for (int i = 0; i < queries.length; i++) {
            int left= queries[i][0];
            int right= queries[i][1];
            int target= Math.max(arr[left], arr[right]);
            if (left > right) {
                int temp = left;
                left = right;
                right = temp;
            }
            if (left == right) {
                answer[i] = left;
                continue;
            }
            if (arr[left] < arr[right]) {
                answer[i] = right;
                continue;
            }
            answer[i]=(query(0, 0, n-1, right+1, n-1, target));
        }
        
        return answer;
    }
    public void build (int [] arr, int index, int left, int right){
        if(left==right){
            segTree[index]=arr[left];
            return;
        }
        int mid= left + (right-left)/2;
        build(arr, 2*index+1, left, mid);
        build(arr, 2*index+2, mid+1, right);
        segTree[index] = Math.max(segTree[2*index+1], segTree[2*index+2]);
    }

    public int query(int index, int left, int right, int queryStart, int queryEnd, int target) {
        if (right < queryStart || segTree[index] <= target) return -1;
        if (left == right){
            return left;
        }
        int mid = (left + right) / 2;
        int leftAns = query(2 * index + 1, left, mid, queryStart, queryEnd, target);
        if (leftAns != -1){
            return leftAns;
        }
        return query(2 * index + 2, mid + 1, right, queryStart, queryEnd, target);
    }
}