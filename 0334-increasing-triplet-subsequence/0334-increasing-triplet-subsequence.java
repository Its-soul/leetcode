// class Solution {
//     public boolean increasingTriplet(int[] nums) {
//         ArrayList<Integer> temp = new ArrayList<>();
//         temp.add(nums[0]);
        
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] > temp.get(temp.size() - 1)) {
//                 temp.add(nums[i]);
//             } else {
//                 int index = Collections.binarySearch(temp, nums[i]);
//                 if (index < 0) {
//                     index = -(index + 1);
//                 }
//                 temp.set(index, nums[i]);
//             }
//         }
//         return (temp.size()<3)? false:true;
//     }
// }

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];

            if (num < first) {
                first = num;
            } else if (num > first && num < second) {
                second = num;
            } else if (num > second) {
                return true;
            }

            i++;
        }
        return false;
    }
}