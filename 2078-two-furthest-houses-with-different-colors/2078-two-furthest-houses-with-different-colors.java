class Solution {
    public int maxDistance(int[] colors) {
        int left=0;
        int right= colors.length-1;
        int max1=0;
        while(left<right){
            if(colors[left]!=colors[right]){
                max1= Math.max(max1,right-left);
                break;
            }
            else if(colors[left]==colors[right]){
                right--;
            }
        }
        left=0;
        right= colors.length-1;
        int max2=0;
        while(left<right){
            if(colors[left]!=colors[right]){
                max2= Math.max(max2,right-left);
                break;
            }
            else if(colors[left]==colors[right]){
                left++;
            }
        }
        return Math.max(max1, max2);
    }
}