class Solution {
    static int [] res;
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        res = new int [nums1.length];
        Arrays.fill(res,-1);
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i]==nums2[j]){
                    // curr_idx=j;
                    for(int k=j+1; k<nums2.length; k++){
                        if(nums2[j]<nums2[k]){
                            res[i]=nums2[k];
                            break;
                        }
                    }
                    // res[i]=-1;
                }
            }
        }
        return res;        
    }
}