class Solution {
    public int minimumEffort(int[][] tasks) {
       Arrays.sort(tasks, (a, b) -> (b[1]-b[0]) - (a[1]-a[0]));
        int minCost=0;
        int curr=0;

        for(int i=0; i<tasks.length; i++){
            if(curr<tasks[i][1]){
                minCost+=tasks[i][1]-curr;
                curr=tasks[i][1];
            }

            curr-=tasks[i][0];
        }
        return minCost;
    }
}