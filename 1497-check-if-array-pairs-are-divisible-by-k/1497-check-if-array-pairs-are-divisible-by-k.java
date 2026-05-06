class Solution {
    public boolean canArrange(int[] arr, int k) {
        for(int i=0; i<arr.length; i++){
            arr[i] = ((arr[i]%k)+k)%k;
        }

        Arrays.sort(arr);
        int left = 0 , right =arr.length-1;
        while(left<=right){
            if(arr[left]==0 ) {
                left++; 
                continue;
            }
           

            if(arr[left]+arr[right]!=k || left==right) return false;
            left++;
            right--;
        }

        return true;
    }
}