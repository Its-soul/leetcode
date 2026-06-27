class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 1;

        for(int num : nums) map.put(num , map.getOrDefault(num , 0) + 1);

        for(int num : map.keySet()){
            if(num == 1){
                int r = map.get(1);
                if(r%2 == 0) r = r -1;
                res = Math.max(res , r );
                continue;
            }
            int x = num;
            int count = 1;
            while(map.containsKey(x*x) && map.get(x) >= 2){
                count += 2;
                x *= x;
            }
            res = Math.max(res , count);
        }
        return res;
    }
}