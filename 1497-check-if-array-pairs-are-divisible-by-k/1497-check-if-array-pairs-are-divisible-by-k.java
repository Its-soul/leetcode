class Solution {
    public boolean canArrange(int[] arr, int k) {
        for(int i=0; i<arr.length; i++){
            arr[i]= ((arr[i]%k)+k)%k;
        }
        int left=0;
        int right= arr.length-1;
        Arrays.sort(arr);
        System.out.print(Arrays.toString(arr));
        while(left<=right){
            if(arr[left]==0){
                left++;
                continue;
            }
            int sum=arr[left]+arr[right];
            if(sum!=k || left==right){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}