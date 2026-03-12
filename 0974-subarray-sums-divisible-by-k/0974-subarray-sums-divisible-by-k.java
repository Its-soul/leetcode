class Solution {
    static HashMap<Integer, Integer> map;
    public int subarraysDivByK(int[] arr, int k) {
        int n= arr.length;
        map= new HashMap<>();
        map.put(0,1);
        int count=0;
        int cursum=0;
        for(int i=0; i<n; i++){
            cursum= cursum+arr[i];
            int rem= ((cursum%k)+k)%k;
            if(map.containsKey(rem)){
                count+=map.get(rem);
               
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}