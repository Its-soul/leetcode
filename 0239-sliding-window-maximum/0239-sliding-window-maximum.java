// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int  [] ans= new int [nums.length-k+1];
//         for(int i=0; i<=nums.length-k; i++){
//             int maxx=Integer.MIN_VALUE;
//             for(int j=i; j<i+k; j++){
//                 if(nums[j]>maxx){
//                     maxx=nums[j];
//                 }
//             }
//             ans[i]=maxx;
//         }
//         return ans;
//     }
// }


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] ans= new int [nums.length-k+1];
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0; i<nums.length; i++){

             while(!dq.isEmpty() && dq.peekFirst()==i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
           
            if(i>=k-1){
                ans[i-k+1]=nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}

// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int [] res= new int [nums.length-k+1];
//         for(int i=0; i<nums.length-k+1; i++){
//             int max=nums[i];
//             for(int j=i; j<i+k; j++){
//                 max= Math.max(max, nums[j]);
//             }
//             res[i]=max;
//         }
//         return res;
//     }
// }