class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n= arr.length;
        int [] prefix= new int [n];
        int [] suffix= new int [n];
        prefix[0]=arr[0];
        suffix[n-1]= arr[n-1];
        for(int i=1; i<n; i++){
            prefix[i]=prefix[i-1]*arr[i];
            suffix[n-i-1]= suffix[n-i]*arr[n-i-1];
        }
        arr[0]=suffix[1];
        arr[n-1]=prefix[n-2];
        for(int i=1; i<n-1; i++){
            arr[i]= suffix[i+1]*prefix[i-1];
        }
        return arr;
    }
}