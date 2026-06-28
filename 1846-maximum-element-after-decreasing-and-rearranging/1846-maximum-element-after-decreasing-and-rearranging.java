// class Solution {
//     public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
//         Arrays.sort(arr);
//         int max= 1;
//         arr[0]= 1;
//         for(int i= 1;i<arr.length;i++){
//             if(arr[i] - arr[i-1]>1){
//                 arr[i] = arr[i-1]+1;
//             }
//             max = Math.max(max,arr[i]);
//         }
//         return max;
//     }
// }


class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] sac = new int[n + 1];
        int hin = 1; 
        for (int i=0; i<arr.length; i++) {
            sac[Math.min(n, arr[i])]++; 
        }

        for (int i = 2; i < sac.length; i++) {
            hin = Math.min(i, hin + sac[i]);
        }
        return hin; 
    }
}