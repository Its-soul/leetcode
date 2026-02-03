// class Solution {
//     public int findCenter(int[][] edges) {
//         int[] arr=new int[edges.length+2];
//         for(int i=0;i<edges.length;i++){
//             arr[edges[i][0]]++;
//             arr[edges[i][1]]++;
//         }
//         for(int i=0;i<arr.length;i++){
//             if(arr[i]==edges.length){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }
// class Solution {
//     public int findCenter(int[][] edges) {
//         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
//         int v=edges.length+1;
// 		for(int i=0;i<v+1;i++){
// 			adj.add(new ArrayList<>());
// 		}
// 		for(int i=0;i<edges.length;i++){
// 			adj.get(edges[i][0]).add(edges[i][1]);
// 			adj.get(edges[i][1]).add(edges[i][0]);
// 		}

//         return helper(adj,edges.length);
//     }
//     public int helper(ArrayList<ArrayList<Integer>> adj,int target){
//         for(int i=0;i<adj.size();i++){
//             int counter=0;
//             for(int j=0;j<adj.get(i).size();j++){
//                 counter++;
//             }
//             if(counter==target){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int findCenter(int[][] edges) {
        int a=edges[0][0];
        int b=edges[0][1];
        int c=edges[1][0];
        int d=edges[1][1];
        if(a==c || a==d){
            return a;
        }
        else{
            return b;
        }
    }
}
