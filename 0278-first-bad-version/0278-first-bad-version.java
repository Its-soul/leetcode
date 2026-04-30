/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long left=1;
        long right=n;
        while(left<right){
            long mid= left+ (right-left)/2;
            if(!isBadVersion((int)mid)){
                left= mid+1;
            }
            else if(isBadVersion((int)mid)){
                right= mid;
            }
        }
        return (int)left;
    }
}